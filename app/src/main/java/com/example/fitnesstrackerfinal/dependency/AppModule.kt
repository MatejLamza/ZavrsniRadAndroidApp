package com.example.fitnesstrackerfinal.dependency

import android.arch.persistence.room.Room
import android.content.Context
import com.example.fitnesstrackerfinal.base.BaseApp
import com.example.fitnesstrackerfinal.data.database.*
import com.example.fitnesstrackerfinal.data.database.online.OnlineDatabaseManager
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.utils.recivers.NetworkChangeReciver
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            MyConstants.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNetworkChangeReceiver(networkChangeReciver: NetworkChangeReciver): NetworkChangeReciver {
        return networkChangeReciver
    }

    @Provides
    @Singleton
    fun provideOnlineDatabaseManager(authInstance: FirebaseAuth, databaseInstance: FirebaseFirestore):OnlineDatabaseManager{
        return OnlineDatabaseManager(authInstance,databaseInstance)
    }

    @Provides
    @Singleton
    fun provideOfflineDatabaseManager(userDAO: UserDAO): OfflineDatabaseManager {
        return OfflineDatabaseManager(userDAO)
    }

    @Singleton
    @Provides
    fun provideOfflineUserDAO(db: UserDatabase): UserDAO {
        return db.getUserDAO()
    }

    @Provides
    @Singleton
    fun provideUserRepo(userRepoImpl: UserRepoImpl): UserRepo {
        return userRepoImpl
    }

    @Singleton
    @Provides
    fun provideFirebaseAuthInstance(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirestoreFirebaseInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}