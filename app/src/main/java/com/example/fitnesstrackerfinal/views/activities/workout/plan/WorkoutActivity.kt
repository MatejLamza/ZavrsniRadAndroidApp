package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Excercise
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.views.adapters.AddExerciseAdapter
import com.example.fitnesstrackerfinal.views.adapters.AddWorkoutAdapter

class WorkoutActivity:AppCompatActivity() {

    var exercises: ArrayList<Excercise> = arrayListOf()

    private lateinit var recyclerView   : RecyclerView
    private lateinit var manager        : LinearLayoutManager
    private lateinit var adapter        : AddExerciseAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        testWorkouts()

        setRecyclerView()
        adapter.loadExercises(exercises)
        adapter.notifyDataSetChanged()

    }

    private fun testWorkouts(){
        var excercise = Excercise()

        excercise.exerciseName = "Sqaut"

        var excercise2 = Excercise()

        excercise2.exerciseName = "Leg press"

        exercises.add(excercise)
        exercises.add(excercise2)

    }


    private fun setRecyclerView(){
        recyclerView = findViewById(R.id.rec_exercises)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(this)
        adapter = AddExerciseAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}