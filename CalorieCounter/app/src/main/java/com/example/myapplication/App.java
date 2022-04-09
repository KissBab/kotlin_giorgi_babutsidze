package com.example.caloriecounter;

import androidx.room.Room
import android.app.Application

public class App: Application {

    lateinit var db: AppDatabase

    companion object {
        private lateinit var instance: App
            private set
    }

    verride fun onCreate() {
        super.onCreate

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "APP_DATABASE"
        ).allowMainThreadQueries().build()
    }

}
