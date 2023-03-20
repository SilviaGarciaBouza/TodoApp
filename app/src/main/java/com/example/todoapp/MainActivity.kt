package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //Listado
    private val categories = listOf (
        TaskCategory.Personal,
        TaskCategory.Bussiness,
        TaskCategory.Others
            )

    private lateinit var rVCategory: RecyclerView
    private lateinit var adapterCategory: AdapterCategory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initUI()

    }

    private fun initComponents() {
        rVCategory = findViewById(R.id.rvTodoCategory)
    }

    private fun initUI() {
        //Inicias el adaptercategory y le envías una lista de categorías
        adapterCategory = AdapterCategory(categories)
        //layoutManager para saber si la lista es horizontal o vertical
        rVCategory.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rVCategory.adapter= adapterCategory
    }
}