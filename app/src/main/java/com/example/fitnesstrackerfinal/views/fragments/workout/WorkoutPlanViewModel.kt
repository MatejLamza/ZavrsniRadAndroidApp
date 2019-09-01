package com.example.fitnesstrackerfinal.views.fragments.workout

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkoutPlanViewModel @Inject constructor(val userRepo: UserRepo): ViewModel() {

    var liveWorkoutsList: MutableLiveData<List<WorkoutPlan>> = MutableLiveData()
    var disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun updateClient(client: Client){
        var disposable = Completable.fromAction{userRepo.updateClient(client)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("aaa","Client successfully updated!!")
            },{
                Log.d("aaa","Burek nejde: ${it.message}")
                it.printStackTrace()
            })
        disposables.add(disposable)
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
        disposables.add(disposable)
    }
}