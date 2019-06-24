package com.example.fitnesstrackerfinal.data

import android.arch.persistence.room.TypeConverter
import com.example.fitnesstrackerfinal.data.models.CachedUser
import com.example.fitnesstrackerfinal.data.models.User
import com.example.fitnesstrackerfinal.data.models.enums.Gender
import com.example.fitnesstrackerfinal.data.models.enums.Goal
import com.example.fitnesstrackerfinal.data.models.info.BasicInformation
import com.example.fitnesstrackerfinal.data.models.info.BasicMeasurements
import com.example.fitnesstrackerfinal.data.models.info.LoginInfo
import com.example.fitnesstrackerfinal.data.models.info.Measurements
import com.example.fitnesstrackerfinal.data.models.workout.Excercise
import com.example.fitnesstrackerfinal.data.models.workout.Workout
import com.example.fitnesstrackerfinal.data.models.workout.WorkoutPlan
import com.google.common.collect.Sets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class DataConverter {
    @TypeConverter
    fun fromUser(user: User): String?{

        val gson = Gson()
        val type = object: TypeToken<User>() {}.type

        return gson.toJson(user,type)
    }

    @TypeConverter
    fun toUser(userString: String): User? {

        val gson = Gson()
        val type = object: TypeToken<User>() {}.type

        return gson.fromJson(userString,type)
    }

//    @TypeConverter
//    fun fromAthleteUser(athleteUser: AthleteUser): String?{
//
//        val gson = Gson()
//        val type = object: TypeToken<AthleteUser>() {}.type
//
//        return gson.toJson(athleteUser,type)
//    }

//    @TypeConverter
//    fun toAthleteUser(athlUserString: String): AthleteUser? {
//
//        val gson = Gson()
//        val type = object: TypeToken<AthleteUser>() {}.type
//
//        return gson.fromJson(athlUserString,type)
//    }

    @TypeConverter
    fun toBasicInformation(stringInfo:String):BasicInformation?{
        val gson = Gson()
        val type = object: TypeToken<BasicInformation>(){}.type

        return gson.fromJson(stringInfo,type)
    }

    @TypeConverter
    fun fromBasicInformation(basicInfo: BasicInformation):String?{
        val gson = Gson()
        val type = object: TypeToken<BasicInformation>() {}.type

        return gson.toJson(basicInfo,type)
    }

    @TypeConverter
    fun toMeasurements(stringMeasure:String):Measurements?{
        val gson = Gson()
        val type = object : TypeToken<Measurements>() {}.type

        return gson.fromJson(stringMeasure,type)
    }

    @TypeConverter
    fun fromMeasurements(measurements: Measurements):String?{
        val gson = Gson()
        val type = object : TypeToken<Measurements>() {}.type

        return gson.toJson(measurements,type)
    }

    @TypeConverter
    fun toBasicMeasure(stringBasicMeasure:String):BasicMeasurements?{
        val gson = Gson()
        val type = object : TypeToken<BasicMeasurements>() {}.type

        return gson.fromJson(stringBasicMeasure,type)
    }

    @TypeConverter
    fun fromBasicMeasure(basicMeasurements: BasicMeasurements):String?{
        val gson = Gson()
        val type = object : TypeToken<BasicMeasurements>() {}.type

        return gson.toJson(basicMeasurements,type)
    }

    @TypeConverter
    fun toLoginInfo(loginInfoStr:String):LoginInfo?{
        val gson = Gson()
        val type = object : TypeToken<LoginInfo>() {}.type

        return gson.fromJson(loginInfoStr,type)
    }

    @TypeConverter
    fun fromLoginInfo(loginInfo: LoginInfo): String?{

        val gson = Gson()
        val type = object: TypeToken<LoginInfo>() {}.type

        return gson.toJson(loginInfo,type)
    }

    @TypeConverter
    fun toGender(genderStr:String):Gender{
        val gson = Gson()
        val type = object : TypeToken<Gender>() {}.type

        return gson.fromJson(genderStr,type)
    }

    @TypeConverter
    fun fromGender(gender: Gender): String?{

        val gson = Gson()
        val type = object: TypeToken<Gender>() {}.type

        return gson.toJson(gender,type)
    }

    @TypeConverter
    fun toCacheUser(cacheUser:String):CachedUser{
        val gson = Gson()
        val type = object : TypeToken<CachedUser>() {}.type

        return gson.fromJson(cacheUser,type)
    }

    @TypeConverter
    fun fromCacheUser(cacheUser: CachedUser): String?{

        val gson = Gson()
        val type = object: TypeToken<Gender>() {}.type

        return gson.toJson(cacheUser,type)
    }

    @TypeConverter
    fun toWorkoutPlan(workoutPlan:String): WorkoutPlan {
        val gson = Gson()
        val type = object : TypeToken<WorkoutPlan>() {}.type

        return gson.fromJson(workoutPlan,type)
    }

    @TypeConverter
    fun fromWorkoutPlan(workoutPlan: WorkoutPlan): String?{

        val gson = Gson()
        val type = object: TypeToken<WorkoutPlan>() {}.type

        return gson.toJson(workoutPlan,type)
    }

    @TypeConverter
    fun toWorkout(workout:String):Workout{
        val gson = Gson()
        val type = object : TypeToken<Workout>() {}.type

        return gson.fromJson(workout,type)
    }

    @TypeConverter
    fun fromWorkout(workout: Workout): String?{

        val gson = Gson()
        val type = object: TypeToken<Workout>() {}.type

        return gson.toJson(workout,type)
    }

    @TypeConverter
    fun toWorkoutList(workouts:String):List<Workout>{
        val gson = Gson()
        val type = object : TypeToken<List<Workout>>() {}.type

        return gson.fromJson(workouts,type)
    }

    @TypeConverter
    fun fromWorkoutList(workouts: List<Workout>): String?{

        val gson = Gson()
        val type = object: TypeToken<List<Workout>>() {}.type

        return gson.toJson(workouts,type)
    }


    @TypeConverter
    fun toExcercise(excercise:String):Excercise{
        val gson = Gson()
        val type = object : TypeToken<Excercise>() {}.type

        return gson.fromJson(excercise,type)
    }

    @TypeConverter
    fun fromExercise(excercise: Excercise): String?{

        val gson = Gson()
        val type = object: TypeToken<Excercise>() {}.type

        return gson.toJson(excercise,type)
    }

    @TypeConverter
    fun toSets(sets:String):Sets{
        val gson = Gson()
        val type = object : TypeToken<Sets>() {}.type

        return gson.fromJson(sets,type)
    }

    @TypeConverter
    fun fromExercise(sets: Sets): String?{

        val gson = Gson()
        val type = object: TypeToken<Sets>() {}.type

        return gson.toJson(sets,type)
    }

    @TypeConverter
    fun toDate(date:String): Date {
        val gson = Gson()
        val type = object : TypeToken<Date>() {}.type

        return gson.fromJson(date,type)
    }

    @TypeConverter
    fun fromDate(date: Date): String?{

        val gson = Gson()
        val type = object: TypeToken<Date>() {}.type

        return gson.toJson(date,type)
    }

    @TypeConverter
    fun toGoal(goal:String): Goal {
        val gson = Gson()
        val type = object : TypeToken<Goal>() {}.type

        return gson.fromJson(goal,type)
    }

    @TypeConverter
    fun fromGoal(goal: Goal): String?{

        val gson = Gson()
        val type = object: TypeToken<Goal>() {}.type

        return gson.toJson(goal,type)
    }


}