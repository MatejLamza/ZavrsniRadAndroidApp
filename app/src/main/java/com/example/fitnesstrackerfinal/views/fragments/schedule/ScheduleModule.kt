package com.example.fitnesstrackerfinal.views.fragments.schedule

import dagger.Module
import dagger.Provides

@Module
class ScheduleModule {
    @Provides
    fun provideScheduleVMFactory():ScheduleVMFactory{
        return ScheduleVMFactory()
    }
}