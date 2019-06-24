package com.example.fitnesstrackerfinal.register

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.example.fitnesstrackerfinal.data.database.UserRepo
import javax.inject.Inject

class RegisterVMFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel() as T
        } else{
            throw IllegalArgumentException("Unknown RegisterViewModel class!")
        }
    }
}