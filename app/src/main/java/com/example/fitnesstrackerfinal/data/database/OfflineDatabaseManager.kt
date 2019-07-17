package com.example.fitnesstrackerfinal.data.database

import android.arch.persistence.room.Query
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class OfflineDatabaseManager
@Inject constructor(val userDAO: UserDAO) {

    fun updateWorkoutPlan(workoutPlan: WorkoutPlan){
        userDAO.updateWorkoutPlan(workoutPlan)
    }

    fun saveWorkoutPlanToOfflineDB(workoutPlan: WorkoutPlan){
        userDAO.saveWorkoutPlanToOfflineDB(workoutPlan)
    }

    fun getAllWorkoutPlansFromOfflineDB():Flowable<List<WorkoutPlan>>{
        return userDAO.getAllWorkoutPlansFromOfflineDB()
    }

    fun getAllClientsFromOfflineDb(): Flowable<List<Client>>{
        return userDAO.getAllClientsFromOfflineDb()
    }

    fun saveClientToOfflineDb(client: Client){
        userDAO.saveClientToOfflineDb(client)
    }

    fun saveUserToOfflineDatabase(user:User){
        userDAO.saveUserToOfflineDatabase(user)
    }

    fun getUserFromOfflineDatabase(email:String, password:String): Single<User> {
        return userDAO.getUserFromOfflineDatabase(email,password)
    }
}