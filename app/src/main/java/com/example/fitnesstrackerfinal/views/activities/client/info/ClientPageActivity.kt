package com.example.fitnesstrackerfinal.views.activities.client.info

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.listeners.RecivedDataListener
import com.example.fitnesstrackerfinal.views.adapters.TabAdapterClient
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientDetailsFragment
import com.example.fitnesstrackerfinal.views.fragments.clients.tabs.ClientWorkoutsFragment
import kotlinx.android.synthetic.main.activity_client_details.*

class ClientPageActivity:AppCompatActivity() {

    private var tabAdapter: TabAdapterClient? = null
    private var tabLayout: TabLayout        ? = null
    private var viewPager:ViewPager         ? = null

    lateinit var recivedInfo: Client
    private var fragment = ClientDetailsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_details)

        if(intent.hasExtra(MyConstants.EXTRA_CLIENT)){
            recivedInfo = intent.getSerializableExtra(MyConstants.EXTRA_CLIENT) as Client
            fragment.recivedClient = recivedInfo
        }

        viewPager = client_details_view_pager
        tabLayout = client_details_tab_layout

        tabAdapter = TabAdapterClient(supportFragmentManager)
        tabAdapter!!.addFragment(fragment,"Details")
        tabAdapter!!.addFragment(ClientWorkoutsFragment(),"Workouts")

        viewPager!!.adapter = tabAdapter
        tabLayout!!.setupWithViewPager(viewPager)

        btn_details.setOnClickListener {
            val intent = Intent(this,ClientInfoActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_CLIENT_STATS,recivedInfo)
            startActivity(intent)
        }

        fab_edit_client.setOnClickListener {
            val intent = Intent(this,ClientEditInfoActivity::class.java)
            intent.putExtra(MyConstants.EXTRA_CLIENT_TO_CLIENT_EDIT_ACT,recivedInfo)
            startActivity(intent)
        }
    }

}