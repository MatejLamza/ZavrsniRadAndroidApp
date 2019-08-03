package com.example.fitnesstrackerfinal.views.activities.workout.exercise

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.view.LayoutInflater
import com.example.fitnesstrackerfinal.R

class AddExerciseDialog:AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(activity)

        var inflater = activity?.layoutInflater
        var view = inflater?.inflate(R.layout.dialog_add_exercise,null)

        builder.setView(view).setTitle("Exercise")

        return builder.create()
    }
}