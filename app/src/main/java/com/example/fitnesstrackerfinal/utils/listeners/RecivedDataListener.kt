package com.example.fitnesstrackerfinal.utils.listeners

import com.example.fitnesstrackerfinal.data.models.Client

interface RecivedDataListener {
    fun onDataRecived(client:Client)
}