package com.example.sofieandroidtest.Model

import com.google.gson.annotations.SerializedName

data class Tarefa(
    //@SerializedName("_id")
    //var _id: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    //@SerializedName("when")
    //var `when`: String

)