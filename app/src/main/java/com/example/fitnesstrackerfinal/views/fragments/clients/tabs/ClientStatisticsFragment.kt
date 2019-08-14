package com.example.fitnesstrackerfinal.views.fragments.clients.tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.info.Measurements
import kotlinx.android.synthetic.main.tab_client_stats.view.*

class ClientStatisticsFragment:Fragment() {

    var client:Client? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.tab_client_stats,container,false)
        setTestData()

        setViews(view)
        return view
    }

    private fun setTestData(){
        var measurements = Measurements()

        measurements.arms = 23.0
        measurements.bodyFatPercent = 10.0
        measurements.chest = 52.0
        measurements.legs = 25.0
        measurements.waist = 43.0

        client!!.currentMeasurements = measurements
    }

    fun setViews(view:View){

        if (client != null){
            view.client_stats_arms.text = client!!.clientMeasurements!!.arms.toString()

            var diff = client!!.clientMeasurements!!.arms?.minus(client!!.currentMeasurements!!.arms!!)

            view.client_stats_arms_diff.text = "+ ${diff?.times(-1)}"

            Log.d("aaa","DIFF JE: $diff")
        }

    }
}