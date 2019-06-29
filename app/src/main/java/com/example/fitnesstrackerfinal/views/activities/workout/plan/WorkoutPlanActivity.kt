package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.views.adapters.AddWorkoutAdapter


class WorkoutPlanActivity:AppCompatActivity() {

    var workouts: ArrayList<Workout> = arrayListOf()

    private lateinit var recyclerView   : RecyclerView
    private lateinit var manager        : LinearLayoutManager
    private lateinit var adapter        : AddWorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_workout_plan)

        setRecyclerView()

        testWorkouts()
        adapter.loadWorkouts(workouts)
        adapter.notifyDataSetChanged()

    }

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