package com.example.fitnesstrackerfinal.views.fragments.clients

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class ClientsModule {
    @Provides
    fun provideClientsViewModelFactory(userRepo: UserRepo):ClientsVMFactory{
        return ClientsVMFactory(userRepo)
    }
}