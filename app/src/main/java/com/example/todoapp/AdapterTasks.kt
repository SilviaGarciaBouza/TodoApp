package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterTasks(private val tasks: List<Tasks>): RecyclerView.Adapter<ViewHolderTasks> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTasks {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_task_layout), parent, false)
        return ViewHolderTasks(view)
    }

    override fun onBindViewHolder(holder: ViewHolderTasks, position: Int) {
        holder.render(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }


}
