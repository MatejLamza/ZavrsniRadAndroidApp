package com.example.fitnesstrackerfinal.views.activities.workout.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class AddWorkoutVMFactory
@Inject constructor(val userRepo: UserRepo) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddWorkoutActivityViewModel::class.java)){
            return AddWorkoutActivityViewModel(userRepo) as T
        } else{
            throw IllegalArgumentException("No such class Add Workout ViewModel")
        }
    }
}