package com.example.fitnesstrackerfinal.views.fragments.clients.tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.utils.listeners.RecivedDataListener
import kotlinx.android.synthetic.main.tab_client_info.*
import kotlinx.android.synthetic.main.tab_client_info.view.*

class ClientDetailsFragment:Fragment() {

    var recivedClient: Client? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.tab_client_info,container,false)

        setAllInfo(view)
        return view
    }

    private fun setAllInfo(view:View){
        if(recivedClient != null){
           view.client_details_Age.text = recivedClient!!.clientBasicInfo?.age.toString()

            view.client_details_bf.text = recivedClient!!.currentMeasurements!!.bodyFatPercent.toString()
            view.client_details_arms.text = recivedClient!!.currentMeasurements?.arms.toString()
            view.client_details_chest.text = recivedClient!!.currentMeasurements?.chest.toString()
            view.client_details_legs.text = recivedClient!!.currentMeasurements?.legs.toString()
            view.client_details_waist.text = recivedClient!!.currentMeasurements?.waist.toString()

            view.client_details_height.text = recivedClient!!.clientBasicMeasurements?.height.toString()
            view.client_details_weight.text = recivedClient!!.clientBasicMeasurements?.weight.toString()
        }
    }
}