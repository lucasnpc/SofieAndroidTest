package com.example.sofieandroidtest.Model

import com.google.gson.annotations.SerializedName

class ListaTarefas()
{
    @SerializedName("data")
    lateinit var tarefas: List<Tarefa>
}