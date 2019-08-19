package com.example.fitnesstrackerfinal.views.activities.client.info

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.InputType
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.utils.MyConstants
import kotlinx.android.synthetic.main.activity_edit_client_info.*

class ClientEditInfoActivity: AppCompatActivity() {

    lateinit var recivedClient: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_client_info)

        if(intent.hasExtra(MyConstants.EXTRA_CLIENT_TO_CLIENT_EDIT_ACT)){
            recivedClient = intent.getSerializableExtra(MyConstants.EXTRA_CLIENT_TO_CLIENT_EDIT_ACT) as Client
            setCurrentDetails()
        }
    }

    private fun setCurrentDetails(){
        et_current_bf.setText(recivedClient.clientMeasurements!!.bodyFatPercent.toString())
        et_current_bf.inputType = InputType.TYPE_NULL

        et_current_arms.setText(recivedClient.clientMeasurements!!.arms.toString())
        et_current_arms.inputType = InputType.TYPE_NULL

        et_current_chest.setText(recivedClient.clientMeasurements!!.chest.toString())
        et_current_chest.inputType = InputType.TYPE_NULL

        et_current_legs.setText(recivedClient.clientMeasurements!!.legs.toString())
        et_current_legs.inputType = InputType.TYPE_NULL

        et_current_waist.setText(recivedClient.clientMeasurements!!.waist.toString())
        et_current_waist.inputType = InputType.TYPE_NULL

        et_current_weight.setText(recivedClient.clientBasicMeasurements!!.weight.toString())
        et_current_weight.inputType = InputType.TYPE_NULL
    }
}