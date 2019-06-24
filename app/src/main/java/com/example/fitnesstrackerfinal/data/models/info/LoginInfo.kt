package com.example.fitnesstrackerfinal.data.models.info

import android.arch.persistence.room.Entity
import java.io.Serializable

@Entity(tableName = "loginInfo")
class LoginInfo:Serializable {
    var email       : String? = null
    var password    : String? = null
    var isCoach     : Boolean = false
}