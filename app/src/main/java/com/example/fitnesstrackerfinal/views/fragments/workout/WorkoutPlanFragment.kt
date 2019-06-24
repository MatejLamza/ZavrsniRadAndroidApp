package com.example.fitnesstrackerfinal.views.fragments.workout

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.workout.AddWorkoutPlanActivity
import com.example.fitnesstrackerfinal.views.adapters.AddWorkoutPlanAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class WorkoutPlanFragment : Fragment() {

    @Inject
    lateinit var factory: WorkoutPlanVMFactory

    var workoutPlans    : List<WorkoutPlan>? = arrayListOf()
    var workoutViewModel: WorkoutPlanViewModel? = null

    private lateinit var recyclerView   : RecyclerView
    private lateinit var manager        : LinearLayoutManager
    private lateinit var adapter        : AddWorkoutPlanAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_workout,container,false)
        val fabAddWorkout: FloatingActionButton = view.findViewById(R.id.fab_AddWorkout)

        setRecyclerView(view)

        workoutViewModel = ViewModelProviders.of(this,factory).get(WorkoutPlanViewModel::class.java)

        workoutViewModel!!.getAllWorkoutPlansFromOfflineDB()

        workoutViewModel!!.liveWorkoutsList.observe(this, Observer {
            workoutPlans = it

            adapter.loadWorkoutPlans(workoutPlans as ArrayList<WorkoutPlan>)
            adapter.notifyDataSetChanged()
        })

        fabAddWorkout.setOnClickListener {
            val intent = Intent(view.context, AddWorkoutPlanActivity::class.java)
            startActivityForResult(intent, MyConstants.REQUEST_CODE_ADD_WORKOUT_PLAN)
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        workoutViewModel!!.getAllWorkoutPlansFromOfflineDB()
    }

    private fun setRecyclerView(view: View){
        recyclerView = view.findViewById(R.id.rec_workouts)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = AddWorkoutPlanAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}