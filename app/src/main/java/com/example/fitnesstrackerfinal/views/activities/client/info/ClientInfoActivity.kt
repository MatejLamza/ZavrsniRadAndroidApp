package com.example.fitnesstrackerfinal.views.activities.client.info

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.views.adapters.TabAdapterClient
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientStatisticsFragment
import kotlinx.android.synthetic.main.activity_client_info.*

class ClientInfoActivity:AppCompatActivity(){

    private var tabAdapter: TabAdapterClient? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_info)

        viewPager = client_info_viewpager
        tabLayout = client_info_tablayout


        tabAdapter = TabAdapterClient(supportFragmentManager)
        tabAdapter!!.addFragment(ClientStatisticsFragment(),"Statistics")

        viewPager!!.adapter = tabAdapter
        tabLayout!!.setupWithViewPager(viewPager)

    }
}