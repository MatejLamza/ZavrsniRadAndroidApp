package com.example.fitnesstrackerfinal.register.basicInfo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class BasicInfoVMFactory @Inject constructor(val userRepo: UserRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BasicInfoViewModel::class.java)){
            return BasicInfoViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("Unknown BasicInfoViewModel class!")
        }
    }
}