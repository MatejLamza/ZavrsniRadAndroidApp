package com.example.fitnesstrackerfinal.views.fragments.clients.tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.enums.Goal
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.views.adapters.ClientPlansAdapter

class ClientAllWorkoutsFragment:Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: ClientPlansAdapter

    private var workoutPlans: ArrayList<WorkoutPlan> = arrayListOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tab_client_workout_plans,container,false)
        setRecyclerView(view)
        testValues()
        adapter.loadWorkouts(workoutPlans)
        adapter.notifyDataSetChanged()
        return view
    }


    private fun testValues(){
        var plan1 = WorkoutPlan()
        plan1.workoutName = "Fat Loss Challenge"
        plan1.goal = Goal.FAT_LOSS


        var plan2 = WorkoutPlan()
        plan2.workoutName = "Strenght in 10 weeks"
        plan2.goal = Goal.STRENGHT

        var plan3 = WorkoutPlan()
        plan3.workoutName = "Muscle Building"
        plan3.goal = Goal.GAIN_MUSCLE

        workoutPlans.add(plan1)
        workoutPlans.add(plan2)
        workoutPlans.add(plan3)


    }

    private fun setRecyclerView(view:View){
        recyclerView = view.findViewById(R.id.rv_all_client_workout_plans)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = ClientPlansAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}