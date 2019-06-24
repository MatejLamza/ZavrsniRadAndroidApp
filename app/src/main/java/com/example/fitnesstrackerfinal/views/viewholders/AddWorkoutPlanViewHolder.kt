package com.example.fitnesstrackerfinal.views.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import kotlinx.android.synthetic.main.item_workout_plan.view.*

class AddWorkoutPlanViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    var workoutPlan: WorkoutPlan? = null

        set(value) {
            field = value

            itemView.tv_workoutPlan_duration.text   = field!!.avgDuration.toString()
            itemView.tv_workoutPlan_duration.text   = field!!.workoutName.toString()
            itemView.tv_Goal.text                   =field!!.goal.toString()
        }
}