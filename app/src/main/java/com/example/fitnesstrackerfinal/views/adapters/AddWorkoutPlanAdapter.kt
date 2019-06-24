package com.example.fitnesstrackerfinal.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.views.viewholders.AddWorkoutPlanViewHolder

class AddWorkoutPlanAdapter: RecyclerView.Adapter<AddWorkoutPlanViewHolder>() {

    private var workoutPlans:List<WorkoutPlan> = arrayListOf()

    fun loadWorkoutPlans(plans:ArrayList<WorkoutPlan>){
        workoutPlans = plans
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AddWorkoutPlanViewHolder
            = AddWorkoutPlanViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_workout_plan,p0,false))

    override fun getItemCount(): Int = workoutPlans.size

    override fun onBindViewHolder(holder: AddWorkoutPlanViewHolder, pos: Int) {
        holder.workoutPlan = workoutPlans[pos]


    }
}