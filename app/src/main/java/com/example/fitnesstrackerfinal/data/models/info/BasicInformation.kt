package com.example.fitnesstrackerfinal.data.models.info

import com.example.fitnesstrackerfinal.data.models.enums.Gender
import java.io.Serializable

class BasicInformation:Serializable {
    var firstName : String? = null
    var lastName  : String? = null
    var age       : Int     = 0
    var gender    : Gender? = null
}