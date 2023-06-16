package com.urialcurry.cursoandroid.toDoApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.urialcurry.cursoandroid.R

class TaskAdapter(private val tasks: List<Task>) :
    RecyclerView.Adapter<TaskViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task,parent,false)

        return TaskViewHolder(view)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position])
    }
}