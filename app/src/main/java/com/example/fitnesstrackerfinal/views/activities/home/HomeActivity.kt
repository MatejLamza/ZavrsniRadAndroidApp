package com.example.fitnesstrackerfinal.views.activities.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.example.fitnesstrackerfinal.views.activities.testProgress
import com.example.fitnesstrackerfinal.views.fragments.clients.ClientsFragment
import com.example.fitnesstrackerfinal.views.fragments.schedule.ScheduleFragment
import com.example.fitnesstrackerfinal.views.fragments.workout.WorkoutPlanFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity: AppCompatActivity() {

    @Inject
    lateinit var homeFactory: HomeVMFactory

    private var homeViewModel: HomeViewModel? = null
    private lateinit var mDrawerLayout: DrawerLayout

    private var clientFragment      = ClientsFragment()
    private var workoutsFragment    = WorkoutPlanFragment()
    private var scheduleFragment    = ScheduleFragment()

    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        homeViewModel = ViewModelProviders.of(this,homeFactory).get(HomeViewModel::class.java)

        homeViewModel!!.getUser()


        mDrawerLayout = findViewById(R.id.drawer_home)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }



        nav_View.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers()

            when(menuItem.itemId){
                R.id.nav_clients -> {
                    openFragment(clientFragment)
                }

                R.id.nav_schedule -> {
                    openFragment(scheduleFragment)
                }

                R.id.nav_workout -> {
                    openFragment(workoutsFragment)
                }

                R.id.nav_settings -> {
                    val intent = Intent(this,testProgress::class.java)
                    startActivity(intent)
                }
            }

            true
        }

        homeViewModel!!.liveUser.observe(this, Observer {
            Log.d("aaa","User u Homeu je :${it!!.basicInfo!!.firstName}")
            //Save user to offline db for cache purposes
            homeViewModel!!.saveUserToOfflineDatabase(it)
        })

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item!!.itemId){
            android.R.id.home ->{
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun openFragment(fragment: Fragment){
        val fragManger = supportFragmentManager
        val fragTransaction = fragManger.beginTransaction()

        fragTransaction.replace(R.id.home_container,fragment).addToBackStack(null).commit()
    }

}