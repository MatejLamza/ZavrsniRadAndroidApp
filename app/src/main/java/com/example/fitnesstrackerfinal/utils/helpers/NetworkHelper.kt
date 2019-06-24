package com.example.fitnesstrackerfinal.utils.helpers

import android.content.Context
import android.net.ConnectivityManager

class NetworkHelper {
    companion object {
        fun checkForInternetConnectivity(context: Context?): Boolean{
            val connectivityManager  = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork        = connectivityManager.activeNetworkInfo

            return activeNetwork != null && activeNetwork.isConnected
        }
    }
}