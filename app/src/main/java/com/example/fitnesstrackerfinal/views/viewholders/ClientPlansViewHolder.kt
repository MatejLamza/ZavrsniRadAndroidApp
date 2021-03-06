package com.example.fitnesstrackerfinal.views.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import kotlinx.android.synthetic.main.item_client_workout_plan.view.*

class ClientPlansViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    var workoutPlan:WorkoutPlan? = null

    set(value) {
        field = value
        itemView.title.text = field!!.workoutName
        itemView.goal.text = field!!.goal.toString()
    }
}