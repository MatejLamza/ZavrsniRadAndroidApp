package com.example.fitnesstrackerfinal.views.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.fitnesstrackerfinal.data.models.CustomEvent
import kotlinx.android.synthetic.main.item_schedule.view.*

class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var event:CustomEvent? = null

    set(value) {
        field = value

        itemView.event_day.text         = field!!.dayOfMonth.toString()
        itemView.event_month.text       = field!!.month.toString()
        itemView.event_name.text        = field!!.eventName
        itemView.even_hour_start.text   = field!!.eventHourStart
        itemView.even_hour_end.text     = field!!.eventHourEnd
        itemView.even_location.text     = field!!.location
        itemView.even_comment.text      = field!!.description
    }
}