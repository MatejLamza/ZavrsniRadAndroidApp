package com.example.fitnesstrackerfinal.views.activities.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.IllegalArgumentException
import javax.inject.Inject

class HomeVMFactory @Inject constructor(val userRepo: UserRepo, val authInstance: FirebaseAuth, val databaseInstance: FirebaseFirestore): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(userRepo,authInstance,databaseInstance) as T
        } else{
            throw IllegalArgumentException("Unknown HomeViewModel Class")
        }
    }
}
