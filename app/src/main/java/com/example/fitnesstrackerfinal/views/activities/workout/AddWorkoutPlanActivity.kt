package com.example.fitnesstrackerfinal.views.activities.workout

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.enums.Goal
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_workout_plan.*
import javax.inject.Inject

class AddWorkoutPlanActivity: AppCompatActivity() {

    @Inject
    lateinit var factory: AddWorkoutPlanVMFactory

    private var addWorkoutPlanViewModel:AddWorkoutPlanViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_workout_plan)

        addWorkoutPlanViewModel = ViewModelProviders.of(this,factory).get(AddWorkoutPlanViewModel::class.java)

        btn_Create_Workout.setOnClickListener {
            val workoutPlan = getWorkoutPlan()
            Log.d("aaa","Workout plan je: ${workoutPlan.avgDuration} ${workoutPlan.frequency} ${workoutPlan.goal}")
            addWorkoutPlanViewModel!!.saveWorkoutPlanToOfflineDB(workoutPlan)
            setResult(Activity.RESULT_OK)
            finish()
        }

    }

    private fun getWorkoutPlan(): WorkoutPlan {
        var workoutPlan = WorkoutPlan()

        workoutPlan.workoutName = et_workout_name.text.toString()
        workoutPlan.frequency = et_num_workouts.text.toString().toInt()
        workoutPlan.avgDuration = et_avg_workout_duration.text.toString().toInt()

        when(spinner_goal.selectedItemPosition){
            0 -> workoutPlan.goal = Goal.FAT_LOSS
            1 -> workoutPlan.goal = Goal.GAIN_MUSCLE
            2 -> workoutPlan.goal = Goal.LOSE_WEIGHT

            else -> workoutPlan.goal = Goal.FAT_LOSS
        }

        return workoutPlan
    }
}