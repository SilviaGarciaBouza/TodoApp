package com.example.todoapp

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Bussiness : TaskCategory()
    object Others : TaskCategory()
}