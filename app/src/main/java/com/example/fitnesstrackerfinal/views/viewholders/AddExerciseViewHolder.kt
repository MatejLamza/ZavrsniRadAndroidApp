package com.example.fitnesstrackerfinal.views.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.fitnesstrackerfinal.data.models.workout.Excercise
import kotlinx.android.synthetic.main.item_exercise.view.*

class AddExerciseViewHolder(itemVIew:View):RecyclerView.ViewHolder(itemVIew) {

    var exercise:Excercise? = null

    set(value) {

        field = value

        itemView.tv_exercise_name.text = field!!.exerciseName
    }
}