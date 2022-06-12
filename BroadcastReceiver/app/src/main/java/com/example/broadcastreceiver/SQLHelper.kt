package com.example.broadcastreceiver

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "airplaneMode.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "airplaneMode_table"
        private const val ID = "ID"
        private const val STATE = "STATE"
        private const val TIME = "TIME"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE" + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY, " + STATE + "REAL, " + TIME + "TEXT" + ")")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun saveAirplaneModeState(airplane: AirplaneEntity): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, airplane.id)
        contentValues.put(STATE, airplane.state)
        contentValues.put(TIME, airplane.date.toString())

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success
    }
}