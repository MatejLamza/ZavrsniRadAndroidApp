package com.example.fitnesstrackerfinal.views.activities.workout.plan

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.workout.viewmodels.AddWorkoutActivityViewModel
import com.example.fitnesstrackerfinal.views.activities.workout.viewmodels.AddWorkoutVMFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activitiy_add_workout.*
import javax.inject.Inject

class AddWorkoutActivity:AppCompatActivity() {

    @Inject
    lateinit var factory: AddWorkoutVMFactory
    private var viewmodel: AddWorkoutActivityViewModel? = null

    private var reciviedWorkoutPlan: WorkoutPlan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_add_workout)

        viewmodel = ViewModelProviders.of(this,factory).get(AddWorkoutActivityViewModel::class.java)

        reciviedWorkoutPlan = intent?.extras!!.get(MyConstants.EXTRA_WORKOUT_PLAN_TO_ADD_ACT) as WorkoutPlan

        btn_add_workout.setOnClickListener {
            val workout = getWorkout()

            reciviedWorkoutPlan!!.workouts.add(workout)
            viewmodel!!.updateWorkoutPlan(reciviedWorkoutPlan!!)

            val intent = Intent(this,WorkoutPlanActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_WORKOUT_TO_WORKOUT_PLAN_ACT,reciviedWorkoutPlan)
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