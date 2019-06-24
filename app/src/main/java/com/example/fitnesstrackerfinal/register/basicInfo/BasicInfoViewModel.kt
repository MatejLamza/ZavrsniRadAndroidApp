package com.example.fitnesstrackerfinal.register.basicInfo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

class BasicInfoViewModel
@Inject constructor(val userRepo: UserRepo): ViewModel() {

    var isRegistrationSuccessfull: MutableLiveData<Boolean> = MutableLiveData()
    private val disposables = CompositeDisposable()


    override fun onCleared() {
        disposables.clear()
    }

    fun registerUser(user: User){
        userRepo.registerUser(user)
    }

//    fun saveUserToOfflineDatabase(user: User){
//        val disposable = Completable.fromAction{ userRepo.saveUserToOfflineDatabase(user)}
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d("aaa","Registration successful")
//                isRegistrationSuccessfull.value = true
//            },{
//                isRegistrationSuccessfull.value = false
//                Log.d("aaa","Registration Failed: ${it.message}")
//            })
//        disposables.add(disposable)
//    }

    //TODO Move to helper class
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

        Log.d("aaa","Registration successful")
        return true
    }
}