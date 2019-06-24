package com.example.fitnesstrackerfinal.views.activities.client

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class AddClientModule {
    @Provides
    fun provideAddClientViewModelFactory(userRepo: UserRepo):AddClientVMFactory{
        return AddClientVMFactory(userRepo)
    }
}