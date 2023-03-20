package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


//Conecta la información con el recyclerView
//Recive la lista que se va a pintar
//Extiende de RecyclerView.Adapter y se le pasa el ViewHolder
class AdapterCategory(private val categories:List<TaskCategory>): RecyclerView.Adapter<ViewHolderCategory>() {

    //Crea la vista para que onBindViewHolder lo pinte
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategory {
        //infla una vista desde un context(no poner this), infla una vista de layout((R.layout.item_category), la del item, parent es dnd se pinta y false)
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_category), parent, false)
        //returna el ViewHolder con la view q acabo de crear
        return ViewHolderCategory(view)
    }

    override fun onBindViewHolder(holder: ViewHolderCategory, position: Int) {
        //holder es como llamar a cada uno de los item
        //la funcion render en el viewHolder, hay q pasarle un item(categoryposition, le vas pasando cada posicion con cada item
       //como tengo la posicion de cada item sé qué item tengo q pasar. Ej: cuando esté en posicion 1 te envío el item de la posición 1
        holder.render(categories[position])
    }

    //Indica el nº de celdas que pinta. Si le pones return 5 solo pintatemos 5
    //categories es la lista que le pasamos a adapterCategory como parametro
    override fun getItemCount(): Int {
        return categories.size
    }
}