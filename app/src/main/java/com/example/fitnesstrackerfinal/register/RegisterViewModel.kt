package com.example.fitnesstrackerfinal.register

import android.arch.lifecycle.ViewModel
import android.text.TextUtils
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import javax.inject.Inject

class RegisterViewModel : ViewModel() {

    fun isRegisterValid(loginInfo: LoginInfo):Boolean{
        if (TextUtils.isEmpty(loginInfo.email) || TextUtils.isEmpty(loginInfo.password)){
            return false
        }
        return true
    }
}