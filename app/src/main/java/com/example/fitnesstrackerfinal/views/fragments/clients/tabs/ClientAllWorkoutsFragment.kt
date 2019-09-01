package com.example.fitnesstrackerfinal.views.fragments.clients.tabs

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.enums.Goal
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.listeners.WorkoutPlanSelectorListener
import com.example.fitnesstrackerfinal.views.activities.client.factories.ClientInfoActivityVMFactory
import com.example.fitnesstrackerfinal.views.activities.client.viewmodels.ClientInfoActivityViewModel
import com.example.fitnesstrackerfinal.views.adapters.ClientPlansAdapter
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanSelectorActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.tab_client_workout_plans.view.*
import javax.inject.Inject

class ClientAllWorkoutsFragment:Fragment() {

    @Inject
    lateinit var factory: ClientInfoActivityVMFactory

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: ClientPlansAdapter

    private var workoutPlans: ArrayList<WorkoutPlan> = arrayListOf()
    private var viewmodel :ClientInfoActivityViewModel? = null

    var currentClient: Client? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tab_client_workout_plans,container,false)

        viewmodel = ViewModelProviders.of(this,factory).get(ClientInfoActivityViewModel::class.java)

        setRecyclerView(view)
//        testValues()

        currentClient?.let { viewmodel!!.updateClient(it) }

        Log.d("aaa","Client ima toliko planova: ${currentClient!!.clientWorkoutPlans!!.allWorkouts.size}")

        currentClient!!.clientWorkoutPlans?.let { adapter.loadWorkouts(it.allWorkouts) }
        adapter.notifyDataSetChanged()


        view.fab_add_plan.setOnClickListener {
            val intent = Intent(it.context,WorkoutPlanSelectorActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_CLIENT_ID,currentClient)
            startActivity(intent)
        }

        return view
    }

//    override fun WorkoutPlanSelectedListener(workoutPlan: WorkoutPlan) {
//        if (workoutPlan.id != null){
//            Log.d("aaa","Radi baki: ${workoutPlan.workoutName}")
//        }
//    }

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

        currentClient!!.clientWorkoutPlans!!.allWorkouts = workoutPlans

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