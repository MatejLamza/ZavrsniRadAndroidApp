package com.example.fitnesstrackerfinal.views.viewholders

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.fitnesstrackerfinal.data.models.Client
import kotlinx.android.synthetic.main.item_client.view.*

class AddClientViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    var client: Client? = null

        @SuppressLint("SetTextI18n")
        set(value) {
            field = value

            itemView.tv_fullName.text   = value!!.clientBasicInfo!!.firstName + value.clientBasicInfo!!.lastName
            itemView.tv_height.text     = value.clientBasicMeasurements!!.height.toString()
            itemView.tv_weight.text     = value.clientBasicMeasurements!!.weight.toString()

        }

}