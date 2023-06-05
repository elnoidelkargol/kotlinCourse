package com.urialcurry.cursoandroid.toDoApp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.urialcurry.cursoandroid.R

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCateogryName : TextView = view.findViewById(R.id.tvCategoryName)
    private val divider : View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){
        tvCateogryName.text = "EJEMPLO"

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
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )
            }
        }

    }
}