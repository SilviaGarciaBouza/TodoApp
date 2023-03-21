package com.example.todoapp

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Bussiness : TaskCategory()
    object Others : TaskCategory()
}

data class Tasks (val taskCategory: TaskCategory, val name: String, var check: Boolean= false, )