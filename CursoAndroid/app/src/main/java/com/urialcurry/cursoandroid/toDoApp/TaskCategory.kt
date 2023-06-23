package com.urialcurry.cursoandroid.toDoApp

sealed class TaskCategory(var isSelected:Boolean = true) {
    object Personal: TaskCategory()
    object Bussines: TaskCategory()
    object Other : TaskCategory()

}