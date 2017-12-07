package main

import java.util.ArrayList

class Disciplina {

    var nome: String? = null
    var alunos: ArrayList<Discentes>? = null
        private set
    var professores: ArrayList<String>? = null
        private set

    constructor(nome: String) {//Construtor "Default"
        alunos = ArrayList()
        professores = ArrayList()
        this.nome = nome
    }

    constructor(nome: String, alunos: ArrayList<Discentes>) {//Construtor com o alunos ja inseridos
        this.nome = nome
        professores = ArrayList()
        this.alunos = alunos
    }

    fun addAlunos(alunos: Discentes) {
        this.alunos!!.add(alunos)
    }

    fun removeAlunos(i: Int) {
        this.alunos!!.removeAt(i)
    }

    fun addProfessores(professores: String) {
        this.professores!!.add(professores)
    }
}
