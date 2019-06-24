package com.example.fitnesstrackerfinal.views.fragments.workout

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkoutPlanViewModel @Inject constructor(val userRepo: UserRepo): ViewModel() {

    var liveWorkoutsList: MutableLiveData<List<WorkoutPlan>> = MutableLiveData()
    var disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getAllWorkoutPlansFromOfflineDB(){
        val disposable = userRepo.getAllWorkoutPlansFromOfflineDB()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveWorkoutsList.value = it
            },{
                Log.d("aaa","Workout nono : ${it.message}")
                it.printStackTrace()
            })
    }
}