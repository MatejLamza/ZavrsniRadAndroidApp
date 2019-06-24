package com.example.fitnesstrackerfinal.login

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    fun provideLoginVMFactory(userRepo: UserRepo):LoginVMFactory{
        return LoginVMFactory(userRepo)
    }
}