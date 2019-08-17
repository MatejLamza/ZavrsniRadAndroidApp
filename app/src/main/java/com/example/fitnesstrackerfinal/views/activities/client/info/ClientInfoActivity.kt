package com.example.fitnesstrackerfinal.views.activities.client.info

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.adapters.TabAdapterClient
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientAllWorkoutsFragment
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientStatisticsFragment
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientWorkoutsFragment
import kotlinx.android.synthetic.main.activity_client_info.*

class ClientInfoActivity:AppCompatActivity(){

    private var tabAdapter  : TabAdapterClient? = null
    private var tabLayout   : TabLayout? = null
    private var viewPager   : ViewPager? = null

    var fragmentStats        = ClientStatisticsFragment()
    var fragmentWorkoutPlans = ClientAllWorkoutsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_info)

        if (intent.hasExtra(MyConstants.EXTRA_CLIENT_STATS)){
            fragmentStats.client = intent.getSerializableExtra(MyConstants.EXTRA_CLIENT_STATS) as Client
            fragmentWorkoutPlans.currentClient = intent.getSerializableExtra(MyConstants.EXTRA_CLIENT_STATS) as Client
        }

        viewPager = client_info_viewpager
        tabLayout = client_info_tablayout


        tabAdapter = TabAdapterClient(supportFragmentManager)
        tabAdapter!!.addFragment(fragmentStats,"Statistics")
        tabAdapter!!.addFragment(fragmentWorkoutPlans,"All workouts")

        viewPager!!.adapter = tabAdapter
        tabLayout!!.setupWithViewPager(viewPager)

    }
}