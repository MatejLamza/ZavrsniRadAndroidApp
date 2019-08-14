package com.example.fitnesstrackerfinal.data.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.BasicMeasurements
import com.example.fitnesstrackerfinal.data.models.info.Measurements
import java.io.Serializable

@Entity(tableName = "clients")
open class Client: Serializable {
    @PrimaryKey(autoGenerate = true)
    var id                      : Int?                  = null
    @Embedded
    var clientBasicInfo         : BasicInformation?     = null
    @Embedded
    var clientBasicMeasurements : BasicMeasurements?    = null
    @Embedded
    var clientMeasurements      : Measurements?         = null
    @Ignore
    var currentMeasurements: Measurements?              = null
}