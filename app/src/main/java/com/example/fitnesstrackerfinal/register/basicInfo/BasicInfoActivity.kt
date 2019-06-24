package com.example.fitnesstrackerfinal.register.basicInfo

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.enums.Gender
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.helpers.NetworkHelper
import com.example.fitnesstrackerfinal.utils.helpers.UserHelper
import com.example.fitnesstrackerfinal.views.activities.home.HomeActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_basic_information.*
import javax.inject.Inject

class BasicInfoActivity:AppCompatActivity() {
    @Inject
    lateinit var basicInfoFactory: BasicInfoVMFactory

    private var basicInfoViewModel: BasicInfoViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_information)

        basicInfoViewModel = ViewModelProviders.of(this,basicInfoFactory).get(BasicInfoViewModel::class.java)

        val recivedLoginInfo = intent.extras.getSerializable(MyConstants.EXTRA_LOGIN_INFO) as LoginInfo


        //TODO SAVE USER TO FIREBASE AND OFFLINE DATABASE
        btn_Register.setOnClickListener {
            val basicInfo = getBasicInformation()
            val user = UserHelper.getUserFromInfo(basicInfo,recivedLoginInfo)
//            IF DEVICE IS CONNECTED TO INTERNET USE ONLINE DB IF NOT USE OFFLINE THEN UPLOAD DATA LATER
            if (NetworkHelper.checkForInternetConnectivity(this)){
                if (UserHelper.isBasicInformationValid(basicInfo)){
                    basicInfoViewModel?.registerUser(user)
                    //TODO Redirect in app
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
//            else{
//                //TODO Give Offline warning and save user to offline database
//                basicInfoViewModel!!.saveUserToOfflineDatabase(user)
//                basicInfoViewModel!!.isRegistrationSuccessfull.observe(this, Observer {
//                    if (it as Boolean){
//                        Toast.makeText(this,"Registration Successful",Toast.LENGTH_SHORT).show()
//                    } else{
//                        Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show()
//                    }
//                })
//            }

        }
    }

    private fun getBasicInformation(): BasicInformation {
        val basicInformation = BasicInformation()

        basicInformation.firstName  = basicInfo_firstName.text.toString()
        basicInformation.lastName   = basicInfo_lastName.text.toString()
        basicInformation.age        = basicInfo_Age.text.toString().toInt()

        when(basicInfo_Gender.selectedItemId){
            1L -> basicInformation.gender   = Gender.MALE
            else -> basicInformation.gender = Gender.FEMALE
        }

        return basicInformation
    }

}