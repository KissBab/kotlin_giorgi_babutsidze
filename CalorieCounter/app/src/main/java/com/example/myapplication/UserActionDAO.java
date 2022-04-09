package com.example.caloriecounter;

import android.app.Notification;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
interface UserActionDAO {

    @Query("SELECT * FROM USER_ACTIONS")
    fun getAllActions(): List<UserAction>

    @Insert(onConflict = onConflictStrategy.REPLACE)
    fun insert(vararg actions: Action)

}
