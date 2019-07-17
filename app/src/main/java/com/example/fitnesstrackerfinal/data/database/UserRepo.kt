package com.example.fitnesstrackerfinal.data.database

import android.content.Context
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Flowable
import io.reactivex.Single

interface UserRepo {

    //Online
    fun signInUserFromOnlineDatabase(loginInfo: LoginInfo, context: Context)
    fun registerUser(user:User)

    //Offline
    fun getUserFromOfflineDatabase(email:String, password:String): Single<User>
    fun getAllClientsFromOfflineDb(): Flowable<List<Client>>
    fun getAllWorkoutPlansFromOfflineDB():Flowable<List<WorkoutPlan>>

    fun updateWorkoutPlan(workoutPlan: WorkoutPlan)


    fun saveUserToOfflineDatabase(user:User)
    fun saveClientToOfflineDb(client: Client)
    fun saveWorkoutPlanToOfflineDB(workoutPlan: WorkoutPlan)

}