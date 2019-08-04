package com.example.fitnesstrackerfinal.views.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.workout.plan.WorkoutPlanActivity
import com.example.fitnesstrackerfinal.views.viewholders.AddWorkoutPlanViewHolder
import kotlinx.android.synthetic.main.item_workout_plan.view.*

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

        holder.itemView.cv_workout_plan.setOnClickListener {
            Log.d("aaa","id je : ${workoutPlans[pos].id}")
            val intent = Intent(it.context,WorkoutPlanActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_WORKOUT_PLAN,workoutPlans[pos].id)
            it.context.startActivity(intent)
        }

    }
}