package com.example.sofieandroidtest.Activitiy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sofieandroidtest.Adapter.AdapterTarefas
import com.example.sofieandroidtest.Model.ListaTarefas
import com.example.sofieandroidtest.Retrofit.RetrofitInit
import com.example.sofieandroidtest.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    fun buscarDados() {
        RetrofitInit.getNetworkInterface().getTarefas().enqueue(object : Callback<ListaTarefas>{
            override fun onResponse(call: Call<ListaTarefas>, response: Response<ListaTarefas>) {
                val resposta = response.body()
                if (resposta != null) {
                    recyclerView.apply {
                        adapter = AdapterTarefas(resposta.tarefas)
                    }
                }
            }

            override fun onFailure(call: Call<ListaTarefas>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Sem resposta do servidor", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        recyclerView = findViewById(R.id.TarefasRecyclerView)

        buscarDados()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}