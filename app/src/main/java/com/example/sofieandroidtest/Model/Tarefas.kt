package com.example.sofieandroidtest.Model

import com.google.gson.annotations.SerializedName

data class Tarefas(
    @SerializedName("_id")
    var id: String,
    @SerializedName("description")
    var descricao: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("when")
    var quando: String,
    @SerializedName("title")
    var titulo: String
)