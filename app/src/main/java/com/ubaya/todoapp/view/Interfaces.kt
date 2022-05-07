package com.ubaya.todoapp.view

import android.view.View
import android.widget.CompoundButton
import com.ubaya.todoapp.model.Todo

interface TodoCheckedChangeListener{
    fun onCheckedChanged( cb:CompoundButton, isChecked: Boolean, obj: Todo)
}
interface TodoEditClickListener{
    fun onTodoEditClick(view:View)
}
interface RadioButtonListener{
    fun onRadioClick(view: View, priority:Int, obj: Todo)
}
interface TodoSaveChangesListener{
    fun onSaveChangeClick (view: View, obj: Todo)
}