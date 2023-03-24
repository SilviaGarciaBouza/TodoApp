package com.example.todoapp

//Deseleccionar categoría:6- propiedad is selected y empieza en true pq empiezan seleccionados
sealed class TaskCategory(var isSelected:Boolean = true) {
    object Personal : TaskCategory()
    object Bussiness : TaskCategory()
    object Others : TaskCategory()
}

data class Tasks (val taskCategory: TaskCategory, val name: String, var check: Boolean= false, )