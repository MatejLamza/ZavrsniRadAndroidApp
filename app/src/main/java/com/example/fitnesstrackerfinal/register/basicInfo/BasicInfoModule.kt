package com.example.fitnesstrackerfinal.register.basicInfo

import com.example.fitnesstrackerfinal.data.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
class BasicInfoModule {
    @Provides
    fun provideBasicInfoViewModelFactory(userRepo: UserRepo):BasicInfoVMFactory{
        return BasicInfoVMFactory(userRepo)
    }
}