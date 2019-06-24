package com.example.fitnesstrackerfinal.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
@Entity(tableName = "Current_logged_user")
class CachedUser {
    @PrimaryKey
    var loggedID : Int? = null
    var user : User? = null
}