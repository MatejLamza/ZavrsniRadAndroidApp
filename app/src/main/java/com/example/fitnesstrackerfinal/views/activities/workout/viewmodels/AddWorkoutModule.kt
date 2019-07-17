package com.example.fitnesstrackerfinal.views.activities.workout.viewmodels

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class AddWorkoutModule {
    @Provides
    fun provideAddWorkoutVMFactory(userRepo: UserRepo):AddWorkoutVMFactory{
        return AddWorkoutVMFactory(userRepo)
    }
}