package com.example.fitnesstrackerfinal.data.models.workout

import java.io.Serializable
import java.util.*

class Workout:Serializable {
    var idWorkout       : Int? = 0
    var day             : Int? = 0
    var image           : Int? = 0
    var workoutName     : String? = null
    var dateOfWorkout   : Date? = null
    var durationOfWorkout: Int? = 0
    var exercises: List<Excercise> = arrayListOf()
}