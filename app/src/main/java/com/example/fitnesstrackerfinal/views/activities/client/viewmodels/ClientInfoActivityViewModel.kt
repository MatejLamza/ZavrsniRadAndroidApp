package com.example.fitnesstrackerfinal.views.activities.client.viewmodels

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.Client
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ClientInfoActivityViewModel
@Inject constructor(val userRepo: UserRepo): ViewModel() {

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun updateClient(client:Client){
        var disposable = Completable.fromAction{userRepo.updateClient(client)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("aaa","Client successfully updated!!")
            },{
                Log.d("aaa","Burek nejde: ${it.message}")
                it.printStackTrace()
            })
    }

}