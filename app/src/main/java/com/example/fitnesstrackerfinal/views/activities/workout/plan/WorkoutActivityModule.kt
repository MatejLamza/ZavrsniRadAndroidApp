package com.example.fitnesstrackerfinal.views.activities.workout.plan

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class WorkoutActivityModule{
    @Provides
    fun prvoideWorkoutActivityVMFactory(userRepo: UserRepo):WorkoutActivityVMFactory{
        return WorkoutActivityVMFactory(userRepo)
    }
}