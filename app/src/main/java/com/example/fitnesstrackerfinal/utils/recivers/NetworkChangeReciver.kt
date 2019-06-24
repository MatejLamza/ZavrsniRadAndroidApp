package com.example.fitnesstrackerfinal.utils.recivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.fitnesstrackerfinal.utils.helpers.NetworkHelper
import com.example.fitnesstrackerfinal.utils.listeners.NetworkStatusListener

class NetworkChangeReciver: BroadcastReceiver() {
    private var networkStatusListener: NetworkStatusListener? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        this.networkStatusListener = context as NetworkStatusListener

        if (!NetworkHelper.checkForInternetConnectivity(context)){
            this.networkStatusListener!!.networkStateChnaged(false)
            Toast.makeText(context,"No internet connection! you are in offline mode.", Toast.LENGTH_LONG).show()
        } else{
            this.networkStatusListener!!.networkStateChnaged(true)
            Toast.makeText(context,"Connected to internet", Toast.LENGTH_LONG).show()
        }
    }
}