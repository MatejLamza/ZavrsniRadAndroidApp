package com.example.fitnesstrackerfinal.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import com.example.fitnesstrackerfinal.data.database.UserRepo
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

class LoginViewModel
@Inject constructor(val userRepo: UserRepo): ViewModel() {

    val isUserFound: MutableLiveData<Boolean> = MutableLiveData()
    val liveUser: MutableLiveData<User> = MutableLiveData()

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }

//

    //TODO ADD VALIDATION
    fun getUserFromOfflineDatabase(email: String, password: String){
        val disposable = userRepo.getUserFromOfflineDatabase(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveUser.value = it
                isUserFound.value = true
            }, {
                liveUser.value = null
                isUserFound.value = false
                Log.d("aaa","${it.message}")
                it.printStackTrace()
            })
        disposables.add(disposable)
    }

    fun onlineUserLogin(loginInfo: LoginInfo, context: Context){
        userRepo.signInUserFromOnlineDatabase(loginInfo, context)
    }

    fun validateLoginFields(loginInfo: LoginInfo):Boolean{
        for(field in LoginInfo::class.memberProperties){
            if (field.get(loginInfo) == ""){
                //TODO Throw fields must not be empty exception!
                Log.d("aaa","Fields must not be empty!")
                return false
            }
        }
        return true
    }

    //    fun getAthleteUserFromOfflineDb(idUser:Int){
//        val disposable = userRepo.getUserAthleteFromOfflineDatabase(idUser)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d("aaa","U VM sam : ${it.userID}")
//                isUserFound.value = true
//            }, {
//                liveUser.value = null
//                isUserFound.value = false
//                Log.d("aaa","${it.message}")
//                it.printStackTrace()
//            })
//        disposables.add(disposable)
//    }

//    fun cacheLoggedInUser(loggedInUser: CacheLoggedInUser){
//        val disposable = Completable.fromAction{ userRepo.cacheLoggedInUser(loggedInUser)}
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d("aaa","Cache successful")
//            },{
//                Log.d("aaa","Cache Failed: ${it.message}")
//            })
//        disposables.add(disposable)
//    }

}