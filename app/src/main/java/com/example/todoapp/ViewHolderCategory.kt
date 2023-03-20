package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

//El que pinta el recyclerView
//Recibe una view y extiende de RecyclerView.ViewHolder, que recive una view
class ViewHolderCategory (view: View): RecyclerView.ViewHolder(view){
    //iniciamos los elementos del xml del item
    private val tvCategoryName: TextView = view.findViewById(R.id.tv_item_category)
    private val vDivider: View = view.findViewById(R.id.v_item_category)

    //render recive un taskcategory
    fun render(taskCategory: TaskCategory) {
        tvCategoryName.text = "Personal"

        //color del divisor:
        when(taskCategory){
            TaskCategory.Bussiness -> {

                tvCategoryName.text = "Trabajo"
               vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.white))
            }
            TaskCategory.Others -> {

                tvCategoryName.text = "Otros"
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.black))

            }
            TaskCategory.Personal -> {

                tvCategoryName.text = "Personal"
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.purple_500))

            }
        }

    }
}