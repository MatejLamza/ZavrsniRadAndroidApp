package com.example.fitnesstrackerfinal.views.activities.client.info

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.views.adapters.TabAdapterClient
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientDetailsFragment
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientWorkoutsFragment
import kotlinx.android.synthetic.main.activity_client_details.*

class ClientPageActivity:AppCompatActivity() {

    private var tabAdapter: TabAdapterClient? = null
    private var tabLayout: TabLayout        ? = null
    private var viewPager:ViewPager         ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_details)

        viewPager = client_details_view_pager
        tabLayout = client_details_tab_layout

        tabAdapter = TabAdapterClient(supportFragmentManager)
        tabAdapter!!.addFragment(ClientDetailsFragment(),"Details")
        tabAdapter!!.addFragment(ClientWorkoutsFragment(),"Workouts")

        viewPager!!.adapter = tabAdapter
        tabLayout!!.setupWithViewPager(viewPager)

    }
}