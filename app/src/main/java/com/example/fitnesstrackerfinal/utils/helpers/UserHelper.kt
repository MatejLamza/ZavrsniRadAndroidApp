package com.example.fitnesstrackerfinal.utils.helpers

import android.util.Log
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import kotlin.reflect.full.memberProperties

class UserHelper {
    companion object {
        fun getUserFromInfo(basicInformation: BasicInformation, loginInfo: LoginInfo): User {
            val user = User()
            user.basicInfo = basicInformation
            user.loginInfo = loginInfo
            return user
        }

        fun isBasicInformationValid(basicInformation: BasicInformation):Boolean{
            for (field in BasicInformation::class.memberProperties){
                if(field.get(basicInformation) == "" ){
                    Log.d("aaa","One of fields are empty.")
                    return false
                }
            }

            if (basicInformation.age < 1 || basicInformation.age > 100){
                //TODO SHOW AGE ERROR
                Log.d("aaa","Entered invalid age")
                return false
            }

            Log.d("aaa","Registration successful USER HELPER")
            return true
        }
    }
}