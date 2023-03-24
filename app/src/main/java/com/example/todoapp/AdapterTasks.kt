package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

////seleccionar y tachar la tarea:3Además de la list, le pasas el OnTaskSelected
class AdapterTasks(var tasks: List<Tasks>, private val onTasksSelected:(Int) -> Unit): RecyclerView.Adapter<ViewHolderTasks> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTasks {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_task_layout), parent, false)
        return ViewHolderTasks(view)
    }


    override fun onBindViewHolder(holder: ViewHolderTasks, position: Int) {
        holder.render(tasks[position])
        //seleccionar y tachar la tarea:4itemView es toda la celda
        holder.itemView.setOnClickListener{onTasksSelected(position)}
    }

    override fun getItemCount(): Int {
        return tasks.size
    }


}
