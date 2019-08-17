package com.example.fitnesstrackerfinal.data.database

import android.content.Context
import com.example.fitnesstrackerfinal.data.database.online.OnlineDatabaseManager
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class UserRepoImpl
@Inject constructor(val onlineDb: OnlineDatabaseManager, val offlineDb:OfflineDatabaseManager):UserRepo{

    override fun updateClient(client: Client) {
       offlineDb.updateClient(client)
    }

    override fun getWorkoutPlanById(idWorkoutPlan: Int): Single<WorkoutPlan> {
        return offlineDb.getWorkoutPlanByID(idWorkoutPlan)
    }

    override fun updateWorkoutPlan(workoutPlan: WorkoutPlan) {
        offlineDb.updateWorkoutPlan(workoutPlan)
    }

    override fun saveWorkoutPlanToOfflineDB(workoutPlan: WorkoutPlan) {
        offlineDb.saveWorkoutPlanToOfflineDB(workoutPlan)
    }

    override fun getAllWorkoutPlansFromOfflineDB(): Flowable<List<WorkoutPlan>> {
       return offlineDb.getAllWorkoutPlansFromOfflineDB()
    }

    override fun getAllClientsFromOfflineDb(): Flowable<List<Client>> {
        return offlineDb.getAllClientsFromOfflineDb()
    }

    override fun saveClientToOfflineDb(client: Client) {
        offlineDb.saveClientToOfflineDb(client)
    }

    override fun saveUserToOfflineDatabase(user: User) {
       offlineDb.saveUserToOfflineDatabase(user)
    }

    override fun registerUser(user: User) {
       onlineDb.registerUser(user)
    }

    override fun signInUserFromOnlineDatabase(loginInfo: LoginInfo, context: Context) {
        onlineDb.signInUserFromOnlineDatabase(loginInfo,context)
    }

    override fun getUserFromOfflineDatabase(email: String, password: String): Single<User> {
        return offlineDb.getUserFromOfflineDatabase(email,password)
    }
}