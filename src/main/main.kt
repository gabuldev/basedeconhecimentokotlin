package main

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>){

     var docentes : ArrayList<Docentes>? = ArrayList()
     var cursos : ArrayList<Curso> = ArrayList()
     var disciplina : ArrayList<Disciplina>? = ArrayList()
     var discente : ArrayList<Discentes>? = ArrayList()
     var x : List<String>? = null
     var cmd : List<String>? = null


    do {

        println("#############- MENU - ###############")
        println("0 - Criar os dados")
        println("1 - Manipular os dados")
        println("2 - Exibir os dados")
        println("Insira uma id e pressione enter: ")
        x=  readLine()!!.split(' ')
        println(x[0].toString().toInt())

        if(x[0].toString().toInt() == 0){
            println("#############- MENU DE CRIAR DADOS- ###############")
            println("0 - Criar um curso")
            println("1 - Criar uma disciplina")
            println("2 - Criar um professor")
            println("3 - Criar um aluno")
            println("Insira uma id e pressione enter")
            cmd =  readLine()!!.split(' ')

            if(cmd[0].toString().toInt() == 0)
                inseredados(0,docentes!!, disciplina!!, discente!!,cursos)

            if(cmd[0].toString().toInt() == 1)
                inseredados(1,docentes!!, disciplina!!, discente!!,cursos)

            if(cmd[0].toString().toInt() == 2)
                inseredados(2,docentes!!, disciplina!!, discente!!,cursos)

            if(cmd[0].toString().toInt() == 3)
                inseredados(3,docentes!!, disciplina!!, discente!!,cursos)



        }

        if (x[0].toString().toInt() == 1){
            println("#############- MENU DE MANIPULAR DADOS- ###############")
            println("0 - Adicionar alunos na disciplina")
            println("1 - Inserido dados ao professore")
            println("Insira uma id e pressione enter")
            cmd =  readLine()!!.split(' ')

            if(cmd[0].toString().toInt() == 0)
                manipula_dados(0, docentes!!,disciplina!!,discente!!,cursos)

            if(cmd[0].toString().toInt() == 1)
                manipula_dados(1,docentes!!,disciplina!!,discente!!,cursos)

        }

        if (x[0].toString().toInt() == 2){
            println("#############- MENU DE EXIBIR DADPS- ###############")
            println("0 - Letra a e b")
            println("1 - Letra  c")
            println("2 - Letra d")
            println("3 - Letra e")
            println("Insira uma id e pressione enter")
            cmd =  readLine()!!.split(' ')

            if(cmd[0].toString().toInt() == 0)
                exibe_dados(0,docentes!!,disciplina!!,discente!!,cursos)
            if(cmd[0].toString().toInt() == 1)
                exibe_dados(1,docentes!!,disciplina!!,discente!!,cursos)
            if(cmd[0].toString().toInt() == 2)
                exibe_dados(2,docentes!!,disciplina!!,discente!!,cursos)

            if(cmd[0].toString().toInt() == 3)
                exibe_dados(3,docentes!!,disciplina!!,discente!!,cursos)

        }
        if (x[0].toString().toInt() == 3)
            println("Fechando...")


    }while (x!![0].toString().toInt() != 3)
}

fun inseredados(id : Int,docentes : ArrayList<Docentes>,disciplina : ArrayList<Disciplina>,discente : ArrayList<Discentes>,cursos : ArrayList<Curso>){

    if(id == 0) {
        println("Favor digitar o nome para o curso: ")
        val cursot = readLine()!!.split(' ')
        println("Curso: " + cursot + " criado com sucesso!")
        cursos.add(Curso(cursot.toString()))
    }
    else if(id == 1) {
        println("Favor digitar o nome para a disciplina: ")
        val disc = readLine()!!.split(' ')
        println("Disciplina: " + disc + " criada com sucesso")
        disciplina.add(Disciplina(disc.toString()))
    }
    else if(id == 2) {
        println("Favor digitar o nome do professo: ")
        val prof = readLine()!!.split(' ')
        println("Professor: " + prof + " inserido  com sucesso")
        docentes.add(Docentes(prof.toString()))
    }
    else if(id == 3) {
        println("Favor digitar o nome do aluno: ")
        val aluno = readLine()!!.split(' ')
        println("Aluno: " + aluno + " inserido com sucesso")
        discente.add(Discentes(aluno.toString()))
    }
    else{
        println("Comando Invalido!")
    }

}


fun manipula_dados(id : Int,docentes : ArrayList<Docentes>,disciplina : ArrayList<Disciplina>,discente : ArrayList<Discentes>,cursos : ArrayList<Curso>){

    var selecionou : List<String>? = null

    if( id == 0){
        println("Selecione uma disciplina da lista:")
        if (disciplina.isEmpty() != true) {
            for (i in 0 until disciplina.size) {
                println(" " + i + " - " + disciplina.get(i).nome)
            }
            println("digite o numero e pressione enter")
            selecionou = readLine()!!.split(' ')
        }
        println("Insira os alunos na disciplina selecionada: ")
        println("Alunos: ")
        for (i in 0 until discente.size) {
            println(" ID: " + i + discente.get(i).nome)
        }
        println("digite a id e pressione enter")
        val digitou = readLine()!!.split(' ')
        disciplina.get(selecionou!![0].toString().toInt()).addAlunos(discente.get(digitou[0].toString().toInt()))
        println("inserido com sucesso!")
    }

    else if(id == 1){

        var prof : List<String>? = null
        var curso : List<String>? = null
        var disc: List<String>? = null

        println("Selecione o professor: ")
        println("Professores")
        for (i in 0 until docentes.size){
            println("ID "+ i + docentes.get(i).nome)
        }
        println("Digite a id e pressione enter")
        prof = readLine()!!.split(' ')

        println("Selecione o curso")
        println("cursos")
        for(i in 0 until cursos.size){
            println("ID " + i + cursos.get(i).nome)
            curso = readLine()!!.split(' ')
        }

        println("Selecione uma disciplina da lista:")
        println("Disciplina: ")
        if (disciplina.isEmpty() != true) {
            for (i in 0 until disciplina.size) {
                println(" " + i + " - " + disciplina.get(i).nome)
            }
            println("digite o numero e pressione enter")
            disc = readLine()!!.split(' ')
        }
        cursos.get(curso!![0].toString().toInt()).addProfessor(docentes.get(prof[0].toString().toInt()).nome.toString())
        disciplina.get(disc!![0].toString().toInt()).addProfessores(docentes.get(prof[0].toString().toInt()).nome.toString())
        docentes.get(prof[0].toString().toInt()).curso = cursos?.get(curso[0].toString().toInt()).nome
        docentes.get(prof[0].toString().toInt()).addDisciplinas(disciplina.get(disc!![0].toString().toInt()))
        println("Operacao realizada com sucesso")
    }
    else{
        println("Comando Invalido")
    }
}

fun exibe_dados(id : Int,docentes : ArrayList<Docentes>,disciplina : ArrayList<Disciplina>,discente : ArrayList<Discentes>,cursos : ArrayList<Curso>){

    var prof : List<String>? = null
    var cmd : List<String>? = null

    //LETRA A e B
    if(id == 0) {
        println("Selecione um professor")
        println("Professores: ")
        for (i in 0 until docentes.size) {
            println("ID: " + i + docentes.get(i).nome)
        }
        println("Digite a id e pressione enter:")
        prof = readLine()!!.split(' ')

        println("Selecione 1- Letra a 2- Letra b")
        cmd = readLine()!!.split(' ')
        if (cmd[0].toString().toInt() == 1) {
            println("Quais disciplinas que o docente ministrou? ")

            for(i in 0 until docentes.get(prof[0].toString().toInt()).disciplinas.size){
                println(docentes.get(prof[0].toString().toInt()).disciplinas.get(i).nome)
            }
        } else if (cmd[0].toString().toInt() == 2) {
            println("O docente pertence a qual curso?")
            println(docentes.get(prof[0].toString().toInt()).curso)
        }
    }
    //LETRA C
    else if(id == 1){
        println("Selecione um curso: " )
        println("cursos: ")
        for(i in 0 until cursos.size){
            println("ID: " + i + cursos.get(i).nome)
        }
        println("Digite o id e pressione enter")
        cmd = readLine()!!.split(' ')
        println("Os professores sao: ")
        println(cursos.get(cmd[0].toString().toInt()).professor)
    }

    //LETRA D
    else if(id == 2){
        println("Selecione uma disciplina: ")
        println("Disciplinas: ")
        for(i in 0 until disciplina.size){
            println("ID: " + i + disciplina.get(i).nome)
        }
        println("Digite o id e pressione enter")
        cmd = readLine()!!.split(' ')
        println("OS professores sao: ")
        println(disciplina.get(cmd[0].toString().toInt()).professores)
    }

    //LETRA E
    else if(id == 3 ){
        var string : String = ""
        println("Selecione um professor: ")
        print("Professores: ")
        for(i in 0 until docentes.size){
            println("ID: " + i + docentes.get(i).nome)
        }
        println("Selecione o ID e pressione enter")
        prof = readLine()!!.split(' ')

        println("Selecione a disciplina: ")
        for (i in 0 until docentes.get(prof[0].toString().toInt()).disciplinas.size){
            println("ID " + i + docentes.get(prof[0].toString().toInt()).disciplinas.get(i).nome )
        }
        println("Selecione o ID e pressione enter")
        cmd = readLine()!!.split(' ')

        println("Os alunos sao: ")
        for(i in 0 until docentes.get(prof[0].toString().toInt()).disciplinas.get(cmd[0].toString().toInt()).alunos!!.size){
            string += " " + docentes.get(prof[0].toString().toInt()).disciplinas.get(cmd[0].toString().toInt()).alunos?.get(i)!!.nome.toString() + " ; "
        }
        println(string)
    }
}