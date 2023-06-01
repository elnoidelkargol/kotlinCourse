package com.urialcurry.cursoandroid.syntaxis

fun main(){
//    inmutableList()
    mutableList()
}

fun mutableList (){
    var weekDays:MutableList<String> = mutableListOf(
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo",
    )

    weekDays.add("DiaAñadido")
    weekDays.add(0,"FirstItem")

    println (weekDays)
}

fun inmutableList (){
    val readOnly:List<String> = listOf(
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo",
    )
    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    val example = readOnly.filter { it.contains("a") }
    println (example)

    readOnly.forEach { weekDay -> println(weekDay) }

}