package com.example.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewHolderTasks(view: View): RecyclerView.ViewHolder(view) {
    private val tvTaskName: TextView = view.findViewById(R.id.tv_item_task)
    private val cbTasks:CheckBox = view.findViewById(R.id.cb_item_task)


    fun render(task: Tasks) {
        tvTaskName.text = task.name
        ////seleccionar y tachar la tarea:5 tachar o destacharal volver a seleccionar
        if (task.check){
            tvTaskName.paintFlags = tvTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG


        } else {tvTaskName.paintFlags = tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()}
        cbTasks.isChecked = task.check
        when(task.taskCategory){
            TaskCategory.Personal -> tvTaskName.setTextColor(ContextCompat.getColor(tvTaskName.context, R.color.purple_500))
            TaskCategory.Bussiness -> tvTaskName.setTextColor(ContextCompat.getColor(tvTaskName.context, R.color.red))
            TaskCategory.Others -> tvTaskName.setTextColor(ContextCompat.getColor(tvTaskName.context, R.color.white))
        }
        ////seleccionar y tachar la tarea:6color en el check
        val color = when(task.taskCategory){
            TaskCategory.Bussiness ->R.color.red
            TaskCategory.Others -> R.color.white
            TaskCategory.Personal -> R.color.purple_500
        }
        cbTasks.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTasks.context,color)
        )

    }
}
