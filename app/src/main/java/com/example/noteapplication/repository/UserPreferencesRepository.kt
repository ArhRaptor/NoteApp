package com.example.noteapplication.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.noteapplication.model.User
import com.google.gson.Gson
import javax.inject.Inject

private const val IS_START_APP = "is_start_app"
private const val IS_LOGIN = "is_login"
private const val USER = "user"
class UserPreferencesRepository @Inject constructor(
    private val userPreferences: SharedPreferences
) {

    fun startApp() {
        userPreferences.edit {
            putBoolean(IS_START_APP, true)
        }
    }

    fun isStartApp(): Boolean {
        return userPreferences.getBoolean(IS_START_APP, false)
    }

    fun login() {
        userPreferences.edit {
            putBoolean(IS_LOGIN, true)
        }
    }

    fun isLogin(): Boolean {
     return userPreferences.getBoolean(IS_LOGIN, false)
    }

    fun putUser(user: User) {
        userPreferences.edit {
            putString(USER, Gson().toJson(user))
        }
    }

    fun getUser(): User? {
        val user = userPreferences.getString(USER, "") ?: ""
        if (user.isBlank()) {
            return null
        }
        return Gson().fromJson(user, User::class.java)
    }

    fun exit() {
        userPreferences.edit {
            putBoolean(IS_LOGIN, false)
            putString(USER, "")
        }
    }
}