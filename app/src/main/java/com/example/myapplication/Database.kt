package com.example.myapplication

import User
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database private constructor(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "barter_system.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "users"

        @Volatile
        private var INSTANCE: Database? = null

        fun getInstance(context: Context): Database {
            return INSTANCE ?: synchronized(this) {
                val instance = INSTANCE ?: Database(context.applicationContext)
                INSTANCE = instance
                instance
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
        CREATE TABLE $TABLE_NAME (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            firstName TEXT NOT NULL,
            lastName TEXT NOT NULL,
            email TEXT NOT NULL UNIQUE,
            password TEXT NOT NULL
        )
        """.trimIndent()

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = """
        DROP TABLE IF EXISTS $TABLE_NAME 
        """.trimIndent()
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun addUser(user: User) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("firstName", user.firstName)
            put("lastName", user.lastName)
            put("email", user.email)
            put("password", user.password)
        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }
}
