package com.urialcurry.cursoandroid.toDoApp

data class Task(val name:String, val category: TaskCategory, val isSelected:Boolean = false) {
}