package com.example.myapplication.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

/**
 * This is where Data Access Object to communicate to database
 */


@Dao
interface UserDao {
    @Upsert
    fun upsertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE email = :userEmail")
    fun getUserByEmail(userEmail: String) : User
}