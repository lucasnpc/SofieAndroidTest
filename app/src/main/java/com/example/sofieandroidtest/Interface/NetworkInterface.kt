package com.example.sofieandroidtest.Interface

import com.example.sofieandroidtest.Model.ListaTarefas
import com.example.sofieandroidtest.Model.Tarefa
import retrofit2.Call
import retrofit2.http.*

interface NetworkInterface {

    companion object {
        val URL_BASE: String = "https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/"

    }
        @GET("task")
        fun getTarefas(): Call<ListaTarefas>

        @Headers("Content-type: application/json")
        @POST("task")
        fun postTarefas(@Body tarefa: Tarefa): Call<Void>

}