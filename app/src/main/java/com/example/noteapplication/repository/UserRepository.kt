package com.example.noteapplication.repository

import com.example.noteapplication.db.UserDao
import com.example.noteapplication.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun addUser(user: User) = userDao.addUser(user)
    suspend fun getUser(email: String) = userDao.getUser(email)
    suspend fun deleteUser(user: User?) = userDao.deleteUser(user)
    suspend fun getUserId(email: String) = userDao.getUserId(email)
}