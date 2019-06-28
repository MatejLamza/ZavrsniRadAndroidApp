package com.example.fitnesstrackerfinal.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import kotlinx.android.synthetic.main.test_home_screen.*

class testProgress:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_home_screen)

        var progresBar = testProg

        progresBar.max = 10000

        progresBar.progress = 2700



    }
}