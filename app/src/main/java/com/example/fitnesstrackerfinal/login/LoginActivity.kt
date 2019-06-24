package com.example.fitnesstrackerfinal.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import android.widget.VideoView
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.register.RegisterActivity
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.helpers.NetworkHelper
import com.example.fitnesstrackerfinal.utils.listeners.NetworkStatusListener
import com.example.fitnesstrackerfinal.utils.listeners.UserFoundListener
import com.example.fitnesstrackerfinal.views.activities.home.HomeActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity: AppCompatActivity(), NetworkStatusListener, UserFoundListener {

    @Inject
    lateinit var loginVMFactory: LoginVMFactory
    private  var loginViewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setVideoBackground()

        loginViewModel = ViewModelProviders.of(this,loginVMFactory).get(LoginViewModel::class.java)

        btn_SignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //TODO Check for internet connectivity
        btn_Login.setOnClickListener {
            Log.d("aaa","CLICKED LOGIN")
            val loginInfo = getLoginInfo()
            if (NetworkHelper.checkForInternetConnectivity(this)){
                //TODO ONLINE STUFF
                if(loginViewModel!!.validateLoginFields(loginInfo)){
                    loginViewModel!!.onlineUserLogin(loginInfo,this)
                }
            } else{
                //TODO OFFLINE STUFF
                Log.d("aaa","off")
                loginViewModel!!.getUserFromOfflineDatabase(loginInfo.email!!,loginInfo.password!!)
            }
        }

        loginViewModel!!.isUserFound.observe(this, Observer {
            it?.let {
                    isSuccess ->
                if (isSuccess){
                    //TODO REDIRECT
                    Toast.makeText(this,"Login successfull", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setVideoBackground(){
        val videoView   = findViewById<VideoView>(R.id.vv_bg_video)
        val uri         = Uri.parse(MyConstants.VIDEO_URI_STRING+packageName+'/'+R.raw.background_video)

        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnPreparedListener {
            it.isLooping = true
        }
    }

    private fun getLoginInfo(): LoginInfo {
        val loginInfo = LoginInfo()
        loginInfo.email     = login_email.text.toString()
        loginInfo.password  = login_password.text.toString()

        return loginInfo
    }

    override fun networkStateChnaged(isConnected: Boolean) {
        if (isConnected){
            Log.d("AAA","Status: Connected")
        } else{
            Log.d("AAA","Status: Disconnected")
        }
    }

    override fun isUserFound(isUserFound: Boolean) {
        if(isUserFound){
            Log.d("aaa","Uspeh ides u home")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else{
            Toast.makeText(this,"User not found check your email and password!",Toast.LENGTH_LONG).show()
        }
    }
}