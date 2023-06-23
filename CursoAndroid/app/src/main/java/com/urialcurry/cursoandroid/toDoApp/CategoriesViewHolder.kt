package com.urialcurry.cursoandroid.toDoApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.urialcurry.cursoandroid.R

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCateogryName : TextView = view.findViewById(R.id.tvCategoryName)
    private val divider : View = view.findViewById(R.id.divider)
    private val viewContainer : CardView = view.findViewById(R.id.viewContainerCategories)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

        val color = if (taskCategory.isSelected){
            R.color.todo_background_card
        }else{
            R.color.todo_background_disabled
        }
        itemView.setOnClickListener{onItemSelected(layoutPosition)}

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context,color))


        when(taskCategory){
            TaskCategory.Bussines -> {
                tvCateogryName.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvCateogryName.text = "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )
            }
            TaskCategory.Personal -> {
                tvCateogryName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category  )
                )
            }
        }

    }
}