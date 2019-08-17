package com.example.fitnesstrackerfinal.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.workout.Workout
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

    @Update
    fun updateWorkoutPlan(workoutPlan: WorkoutPlan)

    @Query("UPDATE clients SET clientWorkoutPlans  = :mWorkoutPlans WHERE id = :mClientId")
    fun updateClientsWorkoutPlans(mClientId:Int,mWorkoutPlans:ArrayList<WorkoutPlan>)
//
    @Update
    fun updateClient(client: Client)

    @Query("SELECT * FROM workoutPlan WHERE id = :idWorkoutPlan")
    fun getWorkoutPlanByID(idWorkoutPlan:Int):Single<WorkoutPlan>

    @Query("SELECT * FROM workoutPlan")
    fun getAllWorkoutPlansFromOfflineDB():Flowable<List<WorkoutPlan>>

    @Query("SELECT * FROM clients")
    fun getAllClientsFromOfflineDb(): Flowable<List<Client>>

    @Query("SELECT * FROM USERS WHERE email = :mEmail AND password = :mPassword")
    fun getUserFromOfflineDatabase(mEmail:String, mPassword:String): Single<User>
}