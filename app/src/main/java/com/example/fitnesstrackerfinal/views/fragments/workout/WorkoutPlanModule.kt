package com.example.fitnesstrackerfinal.views.fragments.workout

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides
@Module
class WorkoutPlanModule {
    @Provides
    fun provideWorkoutVMFactory(userRepo: UserRepo):WorkoutPlanVMFactory{
        return WorkoutPlanVMFactory(userRepo)
    }
}