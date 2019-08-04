package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class WorkoutActivityVMFactory
@Inject constructor(val userRepo: UserRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutActivityViewModel::class.java)){
            return WorkoutActivityViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("No Such Class WorkoutActivityViewModel")
        }
    }
}