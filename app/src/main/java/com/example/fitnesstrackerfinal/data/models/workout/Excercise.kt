package com.example.fitnesstrackerfinal.data.models.workout

class Excercise {
    var idExcercise: Int? = 0
    var exerciseName: String? = null
    var excerciseDescription: String? = null
    var sets: List<Sets> = arrayListOf()
}