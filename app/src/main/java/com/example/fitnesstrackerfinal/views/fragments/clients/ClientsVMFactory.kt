package com.example.fitnesstrackerfinal.views.fragments.clients

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ClientsVMFactory @Inject constructor(val userRepo: UserRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ClientsViewModel::class.java)){
            return ClientsViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("Unknown class ClientsViewModelFactory!!")
        }
    }
}