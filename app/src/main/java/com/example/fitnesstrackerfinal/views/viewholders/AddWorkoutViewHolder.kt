package com.example.fitnesstrackerfinal.views.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import kotlinx.android.synthetic.main.item_workout.view.*

class AddWorkoutViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    var workout:Workout? = null

    set(value) {
        field = value

        itemView.item_workout_day.text = field!!.day.toString()
        itemView.item_workout_name.text = field!!.workoutName
        itemView.item_workout_image.setBackgroundResource(R.drawable.legworkout)

    }

}