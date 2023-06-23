package com.urialcurry.cursoandroid.toDoApp

data class Task(val name:String, val category: TaskCategory, var isSelected:Boolean = false) {
}