package com.example.fitnesstrackerfinal.views.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.listeners.WorkoutPlanSelectorListener
import com.example.fitnesstrackerfinal.views.activities.client.info.ClientInfoActivity
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientAllWorkoutsFragment
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanSelectorActivity
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanViewModel
import com.example.fitnesstrackerfinal.views.viewholders.AddWorkoutPlanViewHolder
import kotlinx.android.synthetic.main.item_workout_plan.view.*

class WorkoutPlanSelectorAdapter(val context:Context): RecyclerView.Adapter<AddWorkoutPlanViewHolder>() {

    private var workoutPlans:List<WorkoutPlan> = arrayListOf()
    private var workoutPlanListener: WorkoutPlanSelectorListener? = null

    fun loadWorkoutPlans(plans:ArrayList<WorkoutPlan>){
        workoutPlans = plans
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AddWorkoutPlanViewHolder
            = AddWorkoutPlanViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_workout_plan,p0,false))


    override fun getItemCount(): Int = workoutPlans.size

    override fun onBindViewHolder(holder: AddWorkoutPlanViewHolder, pos: Int) {
        holder.workoutPlan = workoutPlans[pos]

        holder.itemView.cv_workout_plan.setOnClickListener {
            Log.d("aaa","Click je tu bajo")

            this.workoutPlanListener = context as WorkoutPlanSelectorListener
            workoutPlanListener!!.WorkoutPlanSelectedListener(holder.workoutPlan!!)

//            val intent = Intent(it.context,ClientInfoActivity::class.java)
//            it.context.startActivity(intent)
        }


    }

    fun setListener(listener:WorkoutPlanSelectorListener){
        this.workoutPlanListener = listener
    }


}