package com.urialcurry.cursoandroid.toDoApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.urialcurry.cursoandroid.R

// Pintar las listas y mostrarlas
class CategoriesAdapter(
    private val categories: List<TaskCategory>,
    private val onItemSelected: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    //  Crear la celda del scroller
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)

        return CategoriesViewHolder(view)
    }

    //  Tamaño del listado que se muestra
    //    override fun getItemCount(): Int {
    //        return categories.size
    //    }
    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position],onItemSelected)
    }

}