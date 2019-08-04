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

    @Inject
    lateinit var factory : WorkoutActivityVMFactory

    var viewmodel: WorkoutActivityViewModel? = null

    var workouts: ArrayList<Workout> = arrayListOf()

    private lateinit var recyclerView   : RecyclerView
    private lateinit var manager        : LinearLayoutManager
    private lateinit var adapter        : AddWorkoutAdapter

    private var recivedID :Int = 0
    private var currentWorkoutPlan = WorkoutPlan()


    override fun onResume() {
        super.onResume()

        if (intent.hasExtra(MyConstants.EXTRA_WORKOUT_PLAN)){
            recivedID = intent.getIntExtra(MyConstants.EXTRA_WORKOUT_PLAN,0)
            viewmodel!!.getWorkoutPlayFromDatabase(recivedID)
        }

        if(intent.hasExtra(MyConstants.EXTRA_WORKOUT_TO_WORKOUT_PLAN_ACT)){
            currentWorkoutPlan = intent.getSerializableExtra(MyConstants.EXTRA_WORKOUT_TO_WORKOUT_PLAN_ACT) as WorkoutPlan
            adapter.loadWorkouts(currentWorkoutPlan.workouts)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_workout_plan)
        setRecyclerView()

        viewmodel = ViewModelProviders.of(this,factory).get(WorkoutActivityViewModel::class.java)


        viewmodel!!.liveWorkoutPlan.observe(this, Observer {
            currentWorkoutPlan = it!!
            adapter.loadWorkouts(it.workouts)
            adapter.notifyDataSetChanged()
        })


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


    private fun setRecyclerView(){
        recyclerView = findViewById(R.id.rec_workouts)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter = AddWorkoutAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}