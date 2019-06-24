package com.example.fitnesstrackerfinal.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.CustomEvent
import com.example.fitnesstrackerfinal.views.viewholders.EventViewHolder

class EventAdapter: RecyclerView.Adapter<EventViewHolder>() {

    private var events: List<CustomEvent> = arrayListOf()

    fun loadEvents(recivedEvents:List<CustomEvent>){
        events = recivedEvents
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventViewHolder
        = EventViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_schedule,p0,false))

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventViewHolder, pos: Int) {
        holder.event = events[pos]
    }
}