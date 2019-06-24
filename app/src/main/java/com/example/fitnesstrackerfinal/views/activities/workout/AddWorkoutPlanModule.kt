package com.example.fitnesstrackerfinal.views.activities.workout

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class AddWorkoutPlanModule {
    @Provides
    fun provideAddWorkoutVMFactory(userRepo: UserRepo):AddWorkoutPlanVMFactory{
        return AddWorkoutPlanVMFactory(userRepo)
    }
}