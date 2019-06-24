package com.example.fitnesstrackerfinal.login

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import javax.inject.Inject

class LoginVMFactory @Inject constructor(val userRepo: UserRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("Unknown LoginViewModel class!")
        }
    }
}