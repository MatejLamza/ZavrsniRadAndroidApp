package com.example.fitnesstrackerfinal.data.models.workout

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.fitnesstrackerfinal.data.models.enums.Goal
import java.io.Serializable
import java.util.*

@Entity(tableName = "workoutPlan")
open class WorkoutPlan: Serializable {
    @PrimaryKey(autoGenerate = true)
    var id   : Int? = null
    var workoutName     : String? = null
//    var dateFrom        : Date? = null
//    var dateTo          : Date? = null
    var totalDuration   : String? = null
    var frequency       : Int? = null
    var avgDuration     : Int? = null
    var goal            : Goal? = null
    var workouts        : ArrayList<Workout> = arrayListOf()
}