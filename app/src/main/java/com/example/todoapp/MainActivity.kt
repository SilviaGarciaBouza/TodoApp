package com.example.todoapp

import android.app.Dialog
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    //botón para crear tareas

    //Listado que se va apintar, cada uno de los elementos es un item
    private val categories = listOf (
        TaskCategory.Personal,
        TaskCategory.Bussiness,
        TaskCategory.Others
            )
    private val tasks = mutableListOf<Tasks>(
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
        addTask()

    }

    private fun addTask() {
        val fabAddTask: FloatingActionButton = findViewById(R.id.fab_add_task)
        fabAddTask.setOnClickListener{ dialogAddTask()}
    }

    private fun dialogAddTask() {
        val dialog=Dialog(this)
        dialog.setContentView(R.layout.dialog_add_task)
        dialog.show()

        val editTextAddTask: EditText = dialog.findViewById(R.id.et_add_task)
        val radioGourAddTask: RadioGroup = dialog.findViewById(R.id.rg_add_task)
        val buttonAddTask: Button =dialog.findViewById(R.id.btn_add_task)

        buttonAddTask.setOnClickListener {
            val currentTask = editTextAddTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = radioGourAddTask.checkedRadioButtonId
                val selectedRadioButton: RadioButton = radioGourAddTask.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.personal) -> TaskCategory.Personal
                    getString(R.string.trabajo) -> TaskCategory.Bussiness
                    else -> TaskCategory.Others
                }

                tasks.add(Tasks(currentCategory, editTextAddTask.text.toString()))
                //  updateTasks()
                dialog.hide()
            }
        }


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