package com.urialcurry.cursoandroid.syntaxis

fun main() {

    val weekDays = arrayOf(
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo"
    )

    //Bucles
    for (position in weekDays.indices){
        println(weekDays[position])
    }

    for ((position,value) in weekDays.withIndex()){
        println("La posicion $position tiene el valor $value")
    }
}