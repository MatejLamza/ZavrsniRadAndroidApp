package com.example.fitnesstrackerfinal.views.activities.client

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.data.models.enums.Gender
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.BasicMeasurements
import com.example.fitnesstrackerfinal.data.models.info.Measurements
import com.example.fitnesstrackerfinal.data.models.workout.ClientWorkouts
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_client.*
import javax.inject.Inject

class AddClientActivity: AppCompatActivity()  {

    @Inject
    lateinit var factory: AddClientVMFactory

    private var clientViewmodel:AddClientViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        clientViewmodel = ViewModelProviders.of(this,factory).get(AddClientViewModel::class.java)

        add_btn_finish.setOnClickListener {
            val newClient = getNewClient()
            clientViewmodel!!.saveClientToOfflineDB(newClient)
            //TODO save client to offline db and read from db in ClientFragment
            setResult(Activity.RESULT_OK)
            finish()
        }

    }

    //TODO CHECK IF SOMETHING IS EMPTY
    private fun getNewClient(): Client {
        var client = Client()
        var basicInfo = BasicInformation()
        var basicMeasure = BasicMeasurements()
        var measure = Measurements()
        var currentMeasure = Measurements()

        //BASIC INFORMATION
        basicInfo.firstName = add_first_name.text.toString()
        basicInfo.lastName = add_last_name.text.toString()
        basicInfo.age = add_age.text.toString().toInt()

        if(add_gender.selectedItemPosition == 1){
            basicInfo.gender = Gender.FEMALE
        } else{
            basicInfo.gender = Gender.MALE
        }

        //BASIC MEASUREMENTS
        basicMeasure.height = add_height.text.toString().toDouble()
        basicMeasure.weight = add_weight.text.toString().toDouble()

        //MEASUREMENTS
        measure.bodyFatPercent  = add_bfperc.text.toString().toDouble()
        measure.chest           = add_chest.text.toString().toDouble()
        measure.arms            = add_arms.text.toString().toDouble()
        measure.waist           = add_waist.text.toString().toDouble()
        measure.legs            = add_legs.text.toString().toDouble()

        client.clientBasicInfo          = basicInfo
        client.clientBasicMeasurements  = basicMeasure
        client.clientMeasurements       = measure
        client.clientWorkoutPlans       = ClientWorkouts()
        client.currentMeasurements      = measure

        return client
    }
}