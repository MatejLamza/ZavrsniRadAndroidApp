package com.example.fitnesstrackerfinal.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.views.viewholders.ClientPlansViewHolder

class ClientPlansAdapter: RecyclerView.Adapter<ClientPlansViewHolder>() {

    private var mWorkoutPlans: List<WorkoutPlan> = arrayListOf()

    fun loadWorkouts(workoutPlans:List<WorkoutPlan>){
        mWorkoutPlans = workoutPlans
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ClientPlansViewHolder
        = ClientPlansViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_client_workout_plan,p0,false))

    override fun getItemCount(): Int = mWorkoutPlans.size

    override fun onBindViewHolder(holer: ClientPlansViewHolder, pos: Int) {
        holer.workoutPlan = mWorkoutPlans[pos]

    }


}