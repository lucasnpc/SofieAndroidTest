package com.example.sofieandroidtest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.sofieandroidtest.Model.Tarefa
import com.example.sofieandroidtest.R

class AdapterTarefas(private val listTarefas: List<Tarefa>) :
        RecyclerView.Adapter<AdapterTarefas.TarefasViewHolder>() {



    class TarefasViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_tv)
        val email: TextView = itemView.findViewById(R.id.email_tv)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefasViewHolder {
        val root: View = LayoutInflater.from(parent.context).inflate(R.layout.card_recycler_view, parent, false)
        return TarefasViewHolder(root)
    }

    override fun onBindViewHolder(holder: TarefasViewHolder, position: Int) {
        val tarefa = listTarefas[position]

        holder.title.setText(tarefa.title)
        holder.email.setText(tarefa.email)
    }

    override fun getItemCount() = listTarefas.size

}