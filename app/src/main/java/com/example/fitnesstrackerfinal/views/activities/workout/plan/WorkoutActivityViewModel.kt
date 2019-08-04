package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkoutActivityViewModel
@Inject constructor(val userRepo: UserRepo) : ViewModel() {

    var liveWorkoutPlan:MutableLiveData<WorkoutPlan> = MutableLiveData()

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getWorkoutPlayFromDatabase(id:Int){
        val disposable = userRepo.getWorkoutPlanById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveWorkoutPlan.value = it
            },{
                liveWorkoutPlan.value = null
                it.printStackTrace()
                //TODO Throw custom error
            })

        disposables.addAll(disposable)
    }
}