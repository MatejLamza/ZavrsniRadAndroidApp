package com.example.fitnesstrackerfinal.data.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.BasicMeasurements
import com.example.fitnesstrackerfinal.data.models.info.Measurements
import com.example.fitnesstrackerfinal.data.models.workout.ClientWorkouts
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import java.io.Serializable

@Entity(tableName = "clients")
open class Client: Serializable {
    @PrimaryKey(autoGenerate = true)
    var id                      : Int?                  = null

    var clientWorkoutPlans      : ClientWorkouts?       = null
    @Embedded
    var clientBasicInfo         : BasicInformation?     = null

    @Embedded
    var clientBasicMeasurements : BasicMeasurements?    = null

    @Embedded
    var clientMeasurements      : Measurements?         = null

    @Embedded(prefix = "current_measurements")
    var currentMeasurements     : Measurements?         = null

}