package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

//El que pinta el recyclerView
//Recibe una view y extiende de RecyclerView.ViewHolder, que recive una view
class ViewHolderCategory (view: View): RecyclerView.ViewHolder(view){
    //iniciamos los elementos del xml del item
    private val tvCategoryName: TextView = view.findViewById(R.id.tv_item_category)
    private val vDivider: View = view.findViewById(R.id.v_item_category)
    private val cardCategory: CardView = view.findViewById(R.id.card_category)
    //render recive un taskcategory
    //Deseleccionar categoría:3- Le pasas el onItemSelected
    fun render(taskCategory: TaskCategory, onItemSelected:(Int)->Unit) {
        //Deseleccionar categoría:4- pones el color de las cards
        val color = if(taskCategory.isSelected){
            R.color.purple_200
        } else {
            R.color.purple_1
        }
        cardCategory.setCardBackgroundColor(ContextCompat.getColor(cardCategory.context, color))
        //Deseleccionar categoría:5- a toda la card lle indicas posicon
        itemView.setOnClickListener{onItemSelected(layoutPosition)}


        tvCategoryName.text = "Personal"


        //color del divisor:
        when(taskCategory){
            TaskCategory.Bussiness -> {

                tvCategoryName.text = "Trabajo"
               vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.red))
            }
            TaskCategory.Others -> {

                tvCategoryName.text = "Otros"
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context, R.color.white))

            }
            TaskCategory.Personal -> {

                tvCategoryName.text = "Personal"
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.purple_500))

            }
        }

    }
}