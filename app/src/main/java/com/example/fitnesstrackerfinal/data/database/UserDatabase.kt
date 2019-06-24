package com.example.fitnesstrackerfinal.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.fitnesstrackerfinal.data.DataConverter
import com.example.fitnesstrackerfinal.data.models.CachedUser
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan

@Database(entities = arrayOf(User::class,CachedUser::class, Client::class,WorkoutPlan::class),version = 1,exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUserDAO():UserDAO
}