package com.urialcurry.cursoandroid.toDoApp

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Bussines: TaskCategory()
    object Other : TaskCategory()

}