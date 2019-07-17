package com.example.fitnesstrackerfinal.views.activities.workout.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddWorkoutActivityViewModel
@Inject constructor(val userRepo: UserRepo):ViewModel() {

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun updateWorkoutPlan(workoutPlan: WorkoutPlan){
        var disposable = Completable.fromAction{userRepo.updateWorkoutPlan(workoutPlan)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("aaa","Workout Plan Updated !!")
            },{
                Log.d("aaa","Burek baki nejde update ${it.message}")
                it.printStackTrace()
            })
        disposables.add(disposable)
    }


}