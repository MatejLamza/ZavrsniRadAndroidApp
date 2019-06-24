package com.example.fitnesstrackerfinal.data.models.workout

import java.util.*

class Workout {
    var idWorkout: Int? = 0
    var dateOfWorkout: Date? = null
    var durationOfWorkout: Int? = 0
    var exercises: List<Excercise> = arrayListOf()
}