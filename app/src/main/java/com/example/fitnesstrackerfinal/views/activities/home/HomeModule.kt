package com.example.fitnesstrackerfinal.views.activities.home

import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun provideHomeViewModelFactory(userRepo: UserRepo, authInstance: FirebaseAuth, databaseInstance: FirebaseFirestore):HomeVMFactory{
        return HomeVMFactory(userRepo,authInstance,databaseInstance)
    }
}