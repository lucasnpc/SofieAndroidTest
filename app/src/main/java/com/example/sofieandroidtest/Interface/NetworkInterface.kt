package com.example.sofieandroidtest.Interface

import com.example.sofieandroidtest.Model.ListaTarefas
import com.example.sofieandroidtest.Model.Tarefas
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkInterface {

    companion object {
        val URL_BASE: String = "https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/"

    }
        @GET("task")
        fun getTarefas(): Call<ListaTarefas>

        @POST("")
        fun postTarefas(@Body tarefa: Tarefas): Call<Void>

}