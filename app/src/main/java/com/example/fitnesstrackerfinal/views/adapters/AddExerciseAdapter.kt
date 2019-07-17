package com.example.fitnesstrackerfinal.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.workout.Excercise
import com.example.fitnesstrackerfinal.views.viewholders.AddExerciseViewHolder

class AddExerciseAdapter:RecyclerView.Adapter<AddExerciseViewHolder>() {

    private var listOfExercises: List<Excercise>? = arrayListOf()

    fun loadExercises(exercises:List<Excercise>){
        listOfExercises = exercises
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AddExerciseViewHolder
        = AddExerciseViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_exercise,p0,false))

    override fun getItemCount(): Int
        = listOfExercises!!.size

    override fun onBindViewHolder(holder: AddExerciseViewHolder, pos: Int) {
        holder.exercise = listOfExercises?.get(pos)
    }
}