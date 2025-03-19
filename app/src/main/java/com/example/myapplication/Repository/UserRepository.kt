package com.example.myapplication.Repository

import User
import android.content.Context
import com.example.myapplication.Database

class UserRepository (private val context: Context) {
    private val db = Database.getInstance(context);
    fun addUser(user: User) {
        return db.addUser(user)
    }
}