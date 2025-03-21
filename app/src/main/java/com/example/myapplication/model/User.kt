package com.example.myapplication.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userID: Int,

    @ColumnInfo(name = "first_name")
    @NonNull
    val firstName: String,

    @ColumnInfo(name = "last_name")
    @NonNull
    val lastName: String,

    @ColumnInfo(name = "last_name")
    @NonNull
    val email: String,

    @ColumnInfo(name = "password")
    @NonNull
    val password: String
)
