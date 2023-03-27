package com.example.noteapplication.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.noteapplication.model.User
import com.google.gson.Gson

private const val USER_PREFERENCES = "userPreferences"
private const val IS_START_APP = "is_start_app"
private const val IS_LOGIN = "is_login"
private const val USER ="user"

object UserPreferencesRepository {

    private var userPreferences: SharedPreferences? = null

    fun init(context: Context) {
        if (userPreferences == null) {
            userPreferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
        }
    }

    fun startApp() {
        userPreferences?.edit {
            putBoolean(IS_START_APP, true)
        }
    }

    fun isStartApp(): Boolean = userPreferences?.getBoolean(IS_START_APP, false)?: false

    fun login() {
        userPreferences?.edit {
            putBoolean(IS_LOGIN, true)
        }
    }

    fun isLogin(): Boolean = userPreferences?.getBoolean(IS_LOGIN, false)?: false

    fun putUser(user:User){
        userPreferences?.edit {
            putString(USER, Gson().toJson(user))
        }
    }

    fun getUser(): User?{
        val user = userPreferences?.getString(USER, "")?: ""
        if (user.isBlank()){
            return null
        }
        return Gson().fromJson(user, User::class.java)
    }

    fun exit(){
        userPreferences?.edit {
            putBoolean(IS_LOGIN, false)
            putString(USER, "")
        }
    }
}