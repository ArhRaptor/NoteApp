package com.example.noteapplication.repository

import com.example.noteapplication.db.DataBase
import com.example.noteapplication.model.User

class UserRepository {

    suspend fun addUser(user: User) = DataBase.userDao?.addUser(user)

    suspend fun getUser(email: String) = DataBase.userDao?.getUser(email)

    suspend fun deleteUser(user: User?) = DataBase.userDao?.deleteUser(user)

    suspend fun getUserId(email: String) = DataBase.userDao?.getUserId(email)
}