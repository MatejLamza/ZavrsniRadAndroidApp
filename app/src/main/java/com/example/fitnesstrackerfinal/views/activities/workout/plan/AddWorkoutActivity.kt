package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.utils.MyConstants
import kotlinx.android.synthetic.main.activitiy_add_workout.*

class AddWorkoutActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_add_workout)

        //TODO Add this to db with help of viewmodel look AddWorkoutPlanActivity
        btn_add_workout.setOnClickListener {
            val workout = getWorkout()
            val intent = Intent(this,WorkoutPlanActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_WORKOUT,workout)
            startActivity(intent)
        }
    }

    private fun getWorkout():Workout{
        var workout = Workout()

        workout.day = et_add_workout_day.text.toString().toInt()
        workout.workoutName = et_add_workout_name.text.toString()
        workout.durationOfWorkout = et_add_workout_duration.text.toString().toInt()

        return workout
    }
}