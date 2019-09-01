package com.example.fitnesstrackerfinal.utils

class MyConstants {
    companion object {
        //VIDEO
        const val VIDEO_URI_STRING = "android.resource://"

        //KEYS
        const val EXTRA_LOGIN_INFO      = "login_info"
        const val EXTRA_WORKOUT_PLAN    = "workout_plan"
        const val EXTRA_CLIENT          = "client_extra"
        const val EXTRA_WORKOUT         = "workout_extra"
        const val EXTRA_ITEM_WORKOUT    = "single_workout_extra"
        const val EXTRA_CLIENT_STATS    = "client_stats_extra"
        const val EXTRA_CLIENT_ID       = "client_id_extra"

        const val EXTRA_WORKOUT_PLAN_TO_ADD_ACT     = "extra_workout_plan_to_add_act"
        const val EXTRA_WORKOUT_TO_WORKOUT_PLAN_ACT = "exta_workout_to_workout_plan_act"
        const val EXTRA_CLIENT_TO_CLIENT_EDIT_ACT   = "extra_client_to_client_edit_act"

        //Online Database
        const val USERS = "users"

        //Database
        const val DB_NAME          = "FitnessTrackerDB"

        //Messages
        const val REGISTER_SUCCESS  = "User successfully saved to database"

        //REQUEST CODES
        const val REQUEST_CODE_ADD_CLIENT       = 111
        const val REQUEST_CODE_ADD_WORKOUT_PLAN = 112
        const val CALENDAR_READ_REQUEST_CODE    = 777

        //CALENDAR
        const val PROJECTION_ID_INDEX   : Int = 0
        const val PROJECTION_BEGIN_INDEX: Int = 1
        const val PROJECTION_TITLE_INDEX: Int = 2
        const val PROJECTION_END_INDEX  : Int = 3

    }
}