package com.example.fitnesstrackerfinal.views.activities.workout

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class AddWorkoutPlanVMFactory
@Inject constructor(val userRepo: UserRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(p0: Class<T>): T {
        if(p0.isAssignableFrom(AddWorkoutPlanViewModel::class.java)){
            return AddWorkoutPlanViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("Unkown Class AddWorkoutPlanViewModel")
        }
    }
}