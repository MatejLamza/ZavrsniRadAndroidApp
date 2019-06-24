package com.example.fitnesstrackerfinal.views.fragments.schedule

import android.Manifest
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.CustomEvent
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.adapters.EventAdapter
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import me.everything.providers.android.calendar.CalendarProvider
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer

class ScheduleFragment:Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: EventAdapter

    private var events: ArrayList<CustomEvent> = arrayListOf()
    private lateinit var disposable: Disposable

    override fun onDestroy() {
        if (!disposable.isDisposed){
            disposable.dispose()
        }
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_schedule,container,false)
        setRecyclerView(view)

        var calendarProvider = CalendarProvider(activity)
        var calendar = Calendar.getInstance()

        val startMillis: Long = Calendar.getInstance().run {
            set(this.get(Calendar.YEAR), this.get(Calendar.MONTH), this.get(Calendar.DAY_OF_MONTH), 0, 0)
            timeInMillis
        }

        val endMillis: Long = Calendar.getInstance().run {
            set(this.get(Calendar.YEAR), this.get(Calendar.MONTH), this.get(Calendar.DAY_OF_MONTH), 23, 59)
            timeInMillis
        }

        calendar.timeInMillis = startMillis

        val floatBtnAdd = view.findViewById<FloatingActionButton>(R.id.floatBtn_addSchedule)
        (activity as AppCompatActivity).supportActionBar!!.title = "TODAY"

        if(ContextCompat.checkSelfPermission(this.requireContext(),Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED){
            Log.d("aaa","${calendarProvider.getEvents(1).list.forEach {
                if(it.dTStart >= startMillis && it.dTend <= endMillis ){
                    Log.d("aaa","eventi danas ${it.title}")
                    var myEvent = CustomEvent()
                    myEvent.eventName = it.title
                    myEvent.eventHourStart = getHourFromMilis(it.dTStart)
                    myEvent.eventHourEnd = getHourFromMilis(it.dTend)
                    myEvent.dayOfMonth = getDayOfTheMonthFromMilis(it.dTStart)
                    myEvent.description = it.description
                    myEvent.month = "June"

                    events.add(myEvent)
                }
            }}")

            adapter.loadEvents(events)
            adapter.notifyDataSetChanged()

        } else{
            Log.d("aaa","permission fali")
        }

        floatBtnAdd.setOnClickListener {
            openGoogleCalendar()
        }

        return view
    }


    private fun setRecyclerView(view:View){
        recyclerView = view.findViewById(R.id.rec_schedule)
        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = EventAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    private fun openGoogleCalendar(){
        val intent = Intent(Intent.ACTION_INSERT)
            .setData(CalendarContract.Events.CONTENT_URI)
        startActivity(intent)

    }

    private fun getHourFromMilis(time:Long):String{

        var date = Date()
        var dateFormatHours = SimpleDateFormat("HH:mm")


        date.time = time


        return dateFormatHours.format(date)
    }

    private fun getDayOfTheMonthFromMilis(time:Long):String{
        var date = Date()
        var dateFormatHours = SimpleDateFormat("MM")


        date.time = time


        return dateFormatHours.format(date)
    }


}