package com.example.fitnesstrackerfinal.dependency

import com.example.fitnesstrackerfinal.login.LoginActivity
import com.example.fitnesstrackerfinal.login.LoginModule
import com.example.fitnesstrackerfinal.register.basicInfo.BasicInfoActivity
import com.example.fitnesstrackerfinal.register.basicInfo.BasicInfoModule
import com.example.fitnesstrackerfinal.views.activities.client.AddClientActivity
import com.example.fitnesstrackerfinal.views.activities.client.AddClientModule
import com.example.fitnesstrackerfinal.views.activities.home.HomeActivity
import com.example.fitnesstrackerfinal.views.activities.home.HomeModule
import com.example.fitnesstrackerfinal.views.activities.workout.AddWorkoutPlanActivity
import com.example.fitnesstrackerfinal.views.activities.workout.AddWorkoutPlanModule
import com.example.fitnesstrackerfinal.views.activities.workout.plan.AddWorkoutActivity
import com.example.fitnesstrackerfinal.views.activities.workout.viewmodels.AddWorkoutModule
import com.example.fitnesstrackerfinal.views.fragments.clients.ClientsFragment
import com.example.fitnesstrackerfinal.views.fragments.clients.ClientsModule
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanFragment
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(BasicInfoModule::class))
    abstract fun bindBasicInfoActivity(): BasicInfoActivity

    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    abstract fun bindsLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf(HomeModule::class))
    abstract fun bindsHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = arrayOf(AddClientModule::class))
    abstract fun bindAddClientActivity(): AddClientActivity

    @ContributesAndroidInjector(modules = arrayOf(ClientsModule::class))
    abstract fun bindClientsFragment(): ClientsFragment

    @ContributesAndroidInjector(modules = arrayOf(WorkoutPlanModule::class))
    abstract fun bindWorkoutFragment(): WorkoutPlanFragment

    @ContributesAndroidInjector(modules = arrayOf(AddWorkoutPlanModule::class))
    abstract fun bindAddWorkoutPlanAcivity(): AddWorkoutPlanActivity


    @ContributesAndroidInjector(modules = arrayOf(AddWorkoutModule::class))
    abstract fun bindAddWorkoutActivity(): AddWorkoutActivity
}