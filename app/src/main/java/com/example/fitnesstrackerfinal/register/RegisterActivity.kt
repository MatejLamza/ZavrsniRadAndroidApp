package com.example.fitnesstrackerfinal.register

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.register.basicInfo.BasicInfoActivity
import com.example.fitnesstrackerfinal.utils.MyConstants
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity: AppCompatActivity() {
    var registerViewModel: RegisterViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        btn_BasicInformation.setOnClickListener {
            val loginInfo = getLoginInfo()
            //TODO Check if fields are not empty then forward LoginInfo to BasicInfoActivity
            if (registerViewModel!!.isRegisterValid(loginInfo)){
                Log.d("aaa","Everything is honky dory")
                val intent = Intent(this, BasicInfoActivity::class.java)
                intent.putExtra(MyConstants.EXTRA_LOGIN_INFO,loginInfo)
                startActivity(intent)
            } else{
                Toast.makeText(this,"Make sure that all fields are not empty!!", Toast.LENGTH_LONG).show()
                Log.d("aaa","Not honky dory")
            }
        }
    }

    private fun getLoginInfo(): LoginInfo {
        var loginInfo = LoginInfo()

        loginInfo.email     = register_email.text.toString()
        loginInfo.password  = register_password.text.toString()
        loginInfo.isCoach   = register_isCoach.isChecked

        return loginInfo
    }

}