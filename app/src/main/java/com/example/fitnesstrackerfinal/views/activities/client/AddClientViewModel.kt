package com.example.fitnesstrackerfinal.views.activities.client

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.Client
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddClientViewModel @Inject constructor(val userRepo: UserRepo): ViewModel() {

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun saveClientToOfflineDB(client: Client){
        val disposable = Completable.fromAction{ userRepo.saveClientToOfflineDb(client)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("aaa","Client saved")
            },{
                Log.d("aaa","Client saving Failed: ${it.message}")
            })
        disposables.add(disposable)
    }
}