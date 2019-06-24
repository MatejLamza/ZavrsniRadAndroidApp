package com.example.fitnesstrackerfinal.data.database.online

import android.content.Context
import android.util.Log
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.listeners.UserFoundListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class OnlineDatabaseManager
@Inject constructor(val authInstance: FirebaseAuth, val databaseInstance: FirebaseFirestore){

    private var userFoundListener : UserFoundListener? = null

    fun signInUserFromOnlineDatabase(loginInfo: LoginInfo, context: Context){
        this.userFoundListener = context as UserFoundListener
        authInstance.signInWithEmailAndPassword(loginInfo.email as String,loginInfo.password as String)
            .addOnSuccessListener {this.userFoundListener!!.isUserFound(true)}
            .addOnFailureListener {this.userFoundListener!!.isUserFound(false)}
    }

    fun registerUser(user: User){
        authInstance.
            createUserWithEmailAndPassword(user.loginInfo!!.email.toString(),user.loginInfo!!.password.toString())
            .addOnCompleteListener { if (it.isSuccessful){saveUserToOnlineDatabase(user)} }
            .addOnFailureListener { Log.d("aaa","Error: ${it.message}") }
    }

    fun saveUserToOnlineDatabase(user: User){
        val uid         = authInstance.uid ?: ""
        val databaseRef = databaseInstance.collection(MyConstants.USERS).document(uid)

        user.uid = uid

        databaseRef.set(user)
            .addOnCompleteListener  { Log.d("aaa", MyConstants.REGISTER_SUCCESS) }
            .addOnFailureListener   { Log.d("aaa","Error: ${it.message}") }
    }
}