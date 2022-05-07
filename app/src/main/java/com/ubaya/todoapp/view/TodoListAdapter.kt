package com.ubaya.todoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.todoapp.R
import com.ubaya.todoapp.databinding.LayoutTodoItemBinding
import com.ubaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.layout_todo_item.view.*

class TodoListAdapter(val todoList: ArrayList<Todo>,val adapterOnClick:(Todo) -> Unit):RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(),TodoCheckedChangeListener, TodoEditClickListener{
    class TodoViewHolder(var view: LayoutTodoItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = DataBindingUtil.inflate<LayoutTodoItemBinding>(inflater,R.layout.layout_todo_item,parent,false)
        val view = LayoutTodoItemBinding.inflate(inflater,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.view.todo = todo
        holder.view.checkboxlistener = this
        holder.view.editListener = this
//        with(holder.view){
//            todo = item
//
//
//            checkTask.text = item.title
//            imageEdit.setOnClickListener{
//                val action = TodoListFragmentDirections.actionTodoListFragmentToEditTodoFragment(item.uuid)
//                Navigation.findNavController(it).navigate(action)
//            }
//            checkTask.setOnCheckedChangeListener { compoundButton, b ->
//                if (b) adapterOnClick(todoList[position])
//            }
//        }
//        holder.view.checkTask.text = todoList[position].title
//        holder.view.imageEdit.setOnClickListener{
//            val action = TodoListFragmentDirections.actionTodoListFragmentToEditTodoFragment(todoList[position].uuid)
//            Navigation.findNavController(it).navigate(action)
//        }
//        holder.view.checkTask.setOnCheckedChangeListener { compoundButton, b ->
//            if (b) adapterOnClick(todoList[position])
//        }
    }

    override fun getItemCount() =todoList.size

    fun updateTodoList(newTodoList:List<Todo>){
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun onCheckedChanged(cb: CompoundButton, isChecked: Boolean, obj: Todo) {
        if(isChecked) adapterOnClick(obj)
    }

    override fun onTodoEditClick(view: View) {
        val uuid = view.tag.toString().toInt()
        val action = TodoListFragmentDirections.actionTodoListFragmentToEditTodoFragment(uuid)
        Navigation.findNavController(view).navigate(action)
    }
}


