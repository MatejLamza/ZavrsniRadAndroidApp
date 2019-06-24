package com.example.fitnesstrackerfinal.views.fragments.schedule

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScheduleVMFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScheduleViewModel::class.java)){
            return ScheduleViewModel() as T
        } else{
            throw IllegalArgumentException("Unkown class ScheduleViewModel")
        }
    }
}