package com.example.sofieandroidtest.Activitiy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sofieandroidtest.Model.Tarefa
import com.example.sofieandroidtest.Retrofit.RetrofitInit
import com.example.sofieandroidtest.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTaskActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var titulo: EditText
    lateinit var descricao: EditText

    fun cadastrarDados(tarefa: Tarefa){
        RetrofitInit.getNetworkInterface().postTarefas(tarefa).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@AddTaskActivity, "Tarefa cadastrada com sucesso!", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@AddTaskActivity, "Tarefa não cadastrada!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        setSupportActionBar(findViewById(R.id.toolbar))
        email = findViewById(R.id.emailEditText)
        titulo = findViewById(R.id.tarefaEditText)
        descricao = findViewById(R.id.descricaoEditText)

        findViewById<Button>(R.id.buttom_check).setOnClickListener {
            validaDados()
        }
    }

    private fun validaDados() {
        if (email.text.isEmpty())
            return
        else if (titulo.text.isEmpty())
            return
        else if (descricao.text.isEmpty())
            return
        else {
            cadastrarDados(
                Tarefa(
                    email = email.text.toString(),
                    title = titulo.text.toString(),
                    description = descricao.text.toString(),
                )
            )
        }
    }
}