package com.example.fitnesstrackerfinal.views.activities.client.modules

import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.views.activities.client.factories.ClientInfoActivityVMFactory
import dagger.Module
import dagger.Provides

@Module
class ClientInfoActivityModule {
    @Provides
    fun provideClientInfoActivityVMFactory(userRepo: UserRepo):ClientInfoActivityVMFactory{
        return ClientInfoActivityVMFactory(userRepo)
    }
}