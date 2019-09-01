package com.example.fitnesstrackerfinal.utils.listeners

import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan

interface WorkoutPlanSelectorListener {
    fun WorkoutPlanSelectedListener(workoutPlan:WorkoutPlan)
}