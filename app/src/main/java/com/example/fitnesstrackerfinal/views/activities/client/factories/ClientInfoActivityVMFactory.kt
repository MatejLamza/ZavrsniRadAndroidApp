package com.example.fitnesstrackerfinal.views.activities.client.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.views.activities.client.viewmodels.ClientInfoActivityViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ClientInfoActivityVMFactory
@Inject constructor(val userRepo: UserRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientInfoActivityViewModel::class.java)){
            return ClientInfoActivityViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("Unkown Class ClientInfoActivityViewModel")
        }
    }
}