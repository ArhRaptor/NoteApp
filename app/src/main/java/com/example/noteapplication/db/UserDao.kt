package com.example.noteapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapplication.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM users_table WHERE users_table.email = :email")
    suspend fun getUser(email: String): User

    @Query("SELECT users_table.id FROM users_table WHERE users_table.email = :email")
    suspend fun getUserId(email: String): Long

    @Delete
    suspend fun deleteUser(user: User?)
}