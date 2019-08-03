package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.workout.AddWorkoutPlanViewModel
import com.example.fitnesstrackerfinal.views.activities.workout.viewmodels.AddWorkoutActivityViewModel
import com.example.fitnesstrackerfinal.views.activities.workout.viewmodels.AddWorkoutVMFactory
import com.example.fitnesstrackerfinal.views.adapters.AddWorkoutAdapter
import com.example.fitnesstrackerfinal.views.fragments.clients.ClientsVMFactory
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activitiy_workout_plan.*
import javax.inject.Inject


class WorkoutPlanActivity:AppCompatActivity() {

    var workouts: ArrayList<Workout> = arrayListOf()

    private lateinit var recyclerView   : RecyclerView
    private lateinit var manager        : LinearLayoutManager
    private lateinit var adapter        : AddWorkoutAdapter

    private var currentWorkoutPlan = WorkoutPlan()


    override fun onResume() {
        super.onResume()
        if(intent.extras.get(MyConstants.EXTRA_WORKOUT_TO_WORKOUT_PLAN_ACT) != null){
            currentWorkoutPlan = intent.extras.get(MyConstants.EXTRA_WORKOUT_TO_WORKOUT_PLAN_ACT) as WorkoutPlan
            adapter.loadWorkouts(currentWorkoutPlan.workouts)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_workout_plan)
        setRecyclerView()

        if(intent.extras.get(MyConstants.EXTRA_WORKOUT_PLAN) != null){
            currentWorkoutPlan =  intent?.extras!!.get(MyConstants.EXTRA_WORKOUT_PLAN) as WorkoutPlan
            intent?.extras!!.remove(MyConstants.EXTRA_WORKOUT_PLAN)
        }

        adapter.loadWorkouts(workouts)
        adapter.notifyDataSetChanged()

        btn_Add_workout_plan.setOnClickListener {
            val intent = Intent(this,AddWorkoutActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_WORKOUT_PLAN_TO_ADD_ACT,currentWorkoutPlan)
            startActivity(intent)
        }

//        backLayout.setOnClickListener {
//            val intent = Intent(this,WorkoutPlanFragment::class.java)
//            startActivity(intent)
//        }

    }

    //TODO DELETE
    private fun testWorkouts(){
        var workout1 = Workout()

        workout1.day = 1
        workout1.workoutName = "Legs"

        var workout2 = Workout()

        workout2.day = 2
        workout2.workoutName = "Chest and Back"

        workouts.add(workout1)
        workouts.add(workout2)
    }

    private fun setRecyclerView(){
        recyclerView = findViewById(R.id.rec_workouts)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter = AddWorkoutAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}