package com.example.fitnesstrackerfinal.data.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import java.io.Serializable

@Entity(tableName = "users")
open class User: Serializable {
    @PrimaryKey(autoGenerate = true)
//    var id          : Int?               = 0
    var id          : Int?               = null
    var uid         : String?            = ""
    @Embedded
    var loginInfo   : LoginInfo?         = null
    @Embedded
    var basicInfo   : BasicInformation?  = null
}