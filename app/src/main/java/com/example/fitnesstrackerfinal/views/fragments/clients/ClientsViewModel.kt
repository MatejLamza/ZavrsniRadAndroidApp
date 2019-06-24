package com.example.fitnesstrackerfinal.views.fragments.clients

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.Client
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ClientsViewModel @Inject constructor(val userRepo: UserRepo): ViewModel() {

    var liveClientList: MutableLiveData<List<Client>> = MutableLiveData()
    private val disposables = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getAllClientsFromOfflineDb(){
        val disposable = userRepo.getAllClientsFromOfflineDb()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveClientList.value = it
            },{
                Log.d("aaa","ERROR: ${it.message}")
                it.printStackTrace()
            })
        disposables.add(disposable)
    }
}