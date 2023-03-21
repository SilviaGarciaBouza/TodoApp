package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewHolderTasks(view: View): RecyclerView.ViewHolder(view) {
    private val tvTaskName: TextView = view.findViewById(R.id.tv_item_task)

    fun render(task: Tasks) {
        tvTaskName.text = task.name
        when(task.taskCategory){
            TaskCategory.Personal -> tvTaskName.setTextColor(ContextCompat.getColor(tvTaskName.context, R.color.purple_500))
            TaskCategory.Bussiness -> tvTaskName.setTextColor(ContextCompat.getColor(tvTaskName.context, R.color.red))
            TaskCategory.Others -> tvTaskName.setTextColor(ContextCompat.getColor(tvTaskName.context, R.color.white))
        }

    }
}
