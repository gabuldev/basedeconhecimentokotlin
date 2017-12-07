package main

import java.util.ArrayList

class Docentes(var nome: String?) {
    var curso: String? = null

    val disciplinas: ArrayList<Disciplina>

    init {//Construtor com parametro
        this.disciplinas = ArrayList()
    }

    fun addDisciplinas(disciplina_Ministrou: Disciplina) {
        disciplinas.add(disciplina_Ministrou)
    }

}
