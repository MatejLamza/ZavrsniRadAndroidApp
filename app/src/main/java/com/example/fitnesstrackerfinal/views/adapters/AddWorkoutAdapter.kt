package com.example.fitnesstrackerfinal.views.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.workout.plan.WorkoutActivity
import com.example.fitnesstrackerfinal.views.viewholders.AddWorkoutViewHolder

class AddWorkoutAdapter: RecyclerView.Adapter<AddWorkoutViewHolder>() {

    private var mWorkouts: List<Workout> = arrayListOf()

    fun loadWorkouts(workouts:List<Workout>){
        mWorkouts = workouts
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AddWorkoutViewHolder
        = AddWorkoutViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_workout,p0,false))

    override fun getItemCount(): Int = mWorkouts.size

    override fun onBindViewHolder(holder: AddWorkoutViewHolder, pos: Int) {
       holder.workout = mWorkouts[pos]

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,WorkoutActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_ITEM_WORKOUT,mWorkouts[pos])
            it.context.startActivity(intent)
        }
    }
}