package com.example.fitnesstrackerfinal.views.fragments.workout

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.listeners.WorkoutPlanSelectorListener
import com.example.fitnesstrackerfinal.views.activities.client.info.ClientInfoActivity
import com.example.fitnesstrackerfinal.views.activities.home.HomeActivity
import com.example.fitnesstrackerfinal.views.adapters.AddWorkoutPlanAdapter
import com.example.fitnesstrackerfinal.views.adapters.WorkoutPlanSelectorAdapter
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientAllWorkoutsFragment
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class WorkoutPlanSelectorActivity: AppCompatActivity(),WorkoutPlanSelectorListener {

    @Inject
    lateinit var factory: WorkoutPlanVMFactory

    var workoutPlans    : List<WorkoutPlan>? = arrayListOf()
    var workoutViewModel: WorkoutPlanViewModel? = null

    private lateinit var recyclerView   : RecyclerView
    private lateinit var manager        : LinearLayoutManager
    private lateinit var adapter        : AddWorkoutPlanAdapter
    private lateinit var adapter2       : WorkoutPlanSelectorAdapter

    private var recivied_client_id      :Client? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_workout_plan_selector)

        if(intent.hasExtra(MyConstants.EXTRA_CLIENT_ID)){
            recivied_client_id = intent.getSerializableExtra(MyConstants.EXTRA_CLIENT_ID) as Client
        }

        setRecyclerView()

        workoutViewModel = ViewModelProviders.of(this,factory).get(WorkoutPlanViewModel::class.java)

        workoutViewModel!!.getAllWorkoutPlansFromOfflineDB()

        adapter2.setListener(this)

        workoutViewModel!!.liveWorkoutsList.observe(this, Observer {
            workoutPlans = it
            adapter2.loadWorkoutPlans(workoutPlans as ArrayList<WorkoutPlan>)
            adapter2.notifyDataSetChanged()
        })

    }

    override fun WorkoutPlanSelectedListener(workoutPlan: WorkoutPlan) {
       if(workoutPlan.workoutName != null){
        //TODO Get Client ID here save workout to database and fetch it inside ClientAllWorkoutsFragment
           recivied_client_id!!.clientWorkoutPlans!!.allWorkouts.add(workoutPlan)
           workoutViewModel!!.updateClient(recivied_client_id!!)
           val intent = Intent(this,HomeActivity::class.java)
           startActivity(intent)
       }
    }


    private fun setRecyclerView(){
        recyclerView = findViewById(R.id.rec_workout_plans_selector)

        recyclerView.setHasFixedSize(true)

        manager = GridLayoutManager(applicationContext,2)
//        adapter = AddWorkoutPlanAdapter()
        adapter2 = WorkoutPlanSelectorAdapter(this)

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter2
    }
}