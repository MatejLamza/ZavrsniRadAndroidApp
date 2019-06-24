package com.example.fitnesstrackerfinal.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.views.viewholders.AddClientViewHolder
import kotlinx.android.synthetic.main.item_client.view.*

class AddClientAdapter : RecyclerView.Adapter<AddClientViewHolder>() {

    private var clients: ArrayList<Client> = arrayListOf()

    fun loadClients(clientList: ArrayList<Client>){
        clients = clientList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AddClientViewHolder
            = AddClientViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_client,p0,false))

    override fun getItemCount(): Int = clients.size

    override fun onBindViewHolder(holder: AddClientViewHolder, pos: Int) {
        holder.client = clients[pos]

        holder.itemView.cv_athlete.setOnClickListener {
            Toast.makeText(it.context,"You clicked on: ${holder.client!!.clientBasicInfo!!.firstName}", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.btn_icon_delete.setOnClickListener {

        }
    }
}