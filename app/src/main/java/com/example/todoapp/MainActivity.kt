package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //botón para crear tareas

    //Listado que se va apintar, cada uno de los elementos es un item
    private val categories = listOf (
        TaskCategory.Personal,
        TaskCategory.Bussiness,
        TaskCategory.Others
            )
    private val tasks = listOf<Tasks>(
        Tasks(TaskCategory.Personal, "Lavar ropa", false),
        Tasks(TaskCategory.Bussiness, "Llamar al jefe", false),
        Tasks(TaskCategory.Personal, "Lavar", false),
        Tasks(TaskCategory.Others, "Comida familiar", false),
        Tasks(TaskCategory.Personal, "Comprar", false),
    )
    //Primer RV
    private lateinit var rVCategory: RecyclerView
    private lateinit var adapterCategory: AdapterCategory

    //segundo RV
    private lateinit var rvTasks: RecyclerView
    private lateinit var adapterTasks: AdapterTasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initUI()

    }

    private fun initComponents() {
        rVCategory = findViewById(R.id.rvTodoCategory)
        rvTasks = findViewById(R.id.rvTodoTasks)
    }

    private fun initUI() {
        //Primer rv
        //Inicias el adaptercategory y le envías una lista de categorías
        adapterCategory = AdapterCategory(categories)
        //layoutManager para saber si la lista es horizontal o vertical
        rVCategory.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rVCategory.adapter= adapterCategory

        //segundorv:
        adapterTasks = AdapterTasks(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvTasks.adapter = adapterTasks
    }
}