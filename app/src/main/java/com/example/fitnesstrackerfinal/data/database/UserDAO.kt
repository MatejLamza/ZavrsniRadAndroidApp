package com.example.fitnesstrackerfinal.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface UserDAO {

    @Insert
    fun saveWorkoutPlanToOfflineDB(workoutPlan: WorkoutPlan)

    @Insert
    fun saveClientToOfflineDb(client: Client)

    @Insert
    fun saveUserToOfflineDatabase(user:User)

    @Query("SELECT * FROM workoutPlan")
    fun getAllWorkoutPlansFromOfflineDB():Flowable<List<WorkoutPlan>>

    @Query("SELECT * FROM clients")
    fun getAllClientsFromOfflineDb(): Flowable<List<Client>>

    @Query("SELECT * FROM USERS WHERE email = :mEmail AND password = :mPassword")
    fun getUserFromOfflineDatabase(mEmail:String, mPassword:String): Single<User>
}