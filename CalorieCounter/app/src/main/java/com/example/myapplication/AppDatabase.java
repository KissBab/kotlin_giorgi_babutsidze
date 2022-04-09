package com.example.caloriecounter;

import androidx.room.Database;
import androidx.room.RoomDatabase

@Database(entities = [UserAction::class])
abstract class AppDatabase: RoomDatabase() {

    fun getActionDAO(): UserActionDAO

}
