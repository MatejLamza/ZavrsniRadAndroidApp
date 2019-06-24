package com.example.fitnesstrackerfinal.views.fragments.workout

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class WorkoutPlanVMFactory @Inject constructor(val userRepo: UserRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutPlanViewModel::class.java)){
            return WorkoutPlanViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("Unkown Class WorkoutPlanViewModelFactory!!")
        }
    }
}