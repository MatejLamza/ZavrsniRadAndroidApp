package com.example.fitnesstrackerfinal.data.models.workout

import java.io.Serializable

class Excercise:Serializable {
    var idExcercise: Int? = 0
    var exerciseName: String? = null
    var excerciseDescription: String? = null
    var sets: List<Sets> = arrayListOf()
}