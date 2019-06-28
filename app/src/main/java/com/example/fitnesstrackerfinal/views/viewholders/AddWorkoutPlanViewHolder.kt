package com.example.fitnesstrackerfinal.views.viewholders

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.enums.Goal
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import kotlinx.android.synthetic.main.item_workout_plan.view.*
import kotlinx.android.synthetic.main.item_workout_plan_second.view.*

class AddWorkoutPlanViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    var workoutPlan: WorkoutPlan? = null

        set(value) {
            field = value

//            itemView.tv_workoutPlan_duration.text   = field!!.avgDuration.toString()
//            itemView.tv_workoutPlan_duration.text   = field!!.workoutName.toString()
//            itemView.tv_Goal.text                   =field!!.goal.toString()

//            if (field!!.id!! % 2 == 0){
//                itemView.cv_workout_plan.height = 250
//            }

            when(field!!.goal){
                Goal.FAT_LOSS       -> itemView.tv_item_plan_goal.text = "FAT LOSS"
                Goal.GAIN_MUSCLE    -> itemView.tv_item_plan_goal.text = "MUSCLE"
                Goal.STRENGHT       -> itemView.tv_item_plan_goal.text = "Strenght"
            }

            itemView.tv_item_workout_total_duration.text = field!!.totalDuration + "weeks"
            itemView.iv_item_plan_image.setBackgroundResource(R.drawable.leanmus)
        }
}