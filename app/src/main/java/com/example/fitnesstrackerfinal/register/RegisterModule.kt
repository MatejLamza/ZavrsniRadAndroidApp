package com.example.fitnesstrackerfinal.register

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class RegisterModule {
    @Provides
    fun provideRegisterVMFactory(): RegisterVMFactory {
        return RegisterVMFactory()
    }
}