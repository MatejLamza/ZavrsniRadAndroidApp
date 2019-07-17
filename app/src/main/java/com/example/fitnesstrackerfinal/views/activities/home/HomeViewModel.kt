package com.example.fitnesstrackerfinal.views.activities.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel
@Inject constructor(val userRepo: UserRepo, val authInstance: FirebaseAuth, val databaseInstance: FirebaseFirestore): ViewModel() {

    val liveUser: MutableLiveData<User> = MutableLiveData()

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getUser(){
        val docRef = databaseInstance.collection("users").document(authInstance.currentUser!!.uid)
        docRef.get().addOnSuccessListener { documentSnapshot ->
            val user = documentSnapshot.toObject(User::class.java)!!
            liveUser.value = user
        }
    }

    fun saveUserToOfflineDatabase(user: User){
        val disposable = Completable.fromAction{ userRepo.saveUserToOfflineDatabase(user)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("aaa","Registration successful HOME VM")
            },{
                Log.d("aaa","Registration Failed: ${it.message}")
            })
        disposables.add(disposable)
    }




}