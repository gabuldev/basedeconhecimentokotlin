package main

import java.util.ArrayList

class Curso(var nome: String?) {
    val professor: ArrayList<String>

    init {
        professor = ArrayList()
    }

    fun addProfessor(professor: String) {
        this.professor.add(professor)
    }
}
