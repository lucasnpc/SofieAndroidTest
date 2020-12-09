package com.example.sofieandroidtest.Model

import com.google.gson.annotations.SerializedName

class ListaTarefas()
{

    @SerializedName("data")
    lateinit var tarefas: List<Tarefas>

    @JvmName("getTarefas1")
    fun getTarefas(): List<Tarefas>
    {
        return tarefas
    }
}