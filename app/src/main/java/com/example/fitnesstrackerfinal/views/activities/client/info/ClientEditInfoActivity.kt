package com.example.fitnesstrackerfinal.views.activities.client.info

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.InputType
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.client.factories.ClientInfoActivityVMFactory
import com.example.fitnesstrackerfinal.views.activities.client.viewmodels.ClientInfoActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_edit_client_info.*
import javax.inject.Inject

class ClientEditInfoActivity: AppCompatActivity() {

    @Inject
    lateinit var factory: ClientInfoActivityVMFactory

    private var viewmodel: ClientInfoActivityViewModel? = null


    lateinit var recivedClient: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_client_info)

        viewmodel = ViewModelProviders.of(this,factory).get(ClientInfoActivityViewModel::class.java)

        if(intent.hasExtra(MyConstants.EXTRA_CLIENT_TO_CLIENT_EDIT_ACT)){
            recivedClient = intent.getSerializableExtra(MyConstants.EXTRA_CLIENT_TO_CLIENT_EDIT_ACT) as Client
            setCurrentDetails()
        }

        btn_save_edit.setOnClickListener {
            getNewClientDetails()
            //TODO update client and redirect back to app
            viewmodel!!.updateClient(recivedClient)
            onBackPressed()

        }
    }

    private fun setCurrentDetails(){
        et_current_bf.setText(recivedClient.currentMeasurements!!.bodyFatPercent.toString())
        et_current_bf.inputType = InputType.TYPE_NULL

        et_current_arms.setText(recivedClient.currentMeasurements!!.arms.toString())
        et_current_arms.inputType = InputType.TYPE_NULL

        et_current_chest.setText(recivedClient.currentMeasurements!!.chest.toString())
        et_current_chest.inputType = InputType.TYPE_NULL

        et_current_legs.setText(recivedClient.currentMeasurements!!.legs.toString())
        et_current_legs.inputType = InputType.TYPE_NULL

        et_current_waist.setText(recivedClient.currentMeasurements!!.waist.toString())
        et_current_waist.inputType = InputType.TYPE_NULL

        et_current_weight.setText(recivedClient.clientBasicMeasurements!!.weight.toString())
        et_current_weight.inputType = InputType.TYPE_NULL
    }

    private fun getNewClientDetails(){
        recivedClient.currentMeasurements!!.bodyFatPercent = et_new_bf.text.toString().toDouble()
        recivedClient.currentMeasurements!!.waist = et_new_waist.text.toString().toDouble()
        recivedClient.currentMeasurements!!.legs = et_new_legs.text.toString().toDouble()
        recivedClient.currentMeasurements!!.arms = et_new_arms.text.toString().toDouble()
        recivedClient.currentMeasurements!!.chest = et_current_chest.text.toString().toDouble()
    }
}