package com.example.fitnesstrackerfinal.views.activities.workout

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddWorkoutPlanViewModel
@Inject constructor(val userRepo: UserRepo): ViewModel() {

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun saveWorkoutPlanToOfflineDB(workoutPlan: WorkoutPlan){
        val disposable = Completable.fromAction { userRepo.saveWorkoutPlanToOfflineDB(workoutPlan) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("aaa","Workout Plan Saved!!")
            },{
                Log.d("aaa","Workout Plan not Saved ${it.message}")
                it.printStackTrace()
            })
        disposables.add(disposable)
    }
}