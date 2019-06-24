package com.example.fitnesstrackerfinal.views.activities.client

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class AddClientVMFactory
@Inject constructor(val userRepo: UserRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddClientViewModel::class.java)){
                return AddClientViewModel(userRepo) as T
            } else{
                throw IllegalArgumentException("Unknown HomeViewModel Class")
            }
        }
}