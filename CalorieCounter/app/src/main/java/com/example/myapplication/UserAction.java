package com.example.caloriecounter;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USER_ACTIONS")
data class UserAction {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ACTION_ID")
    val id: Int

    @ColumnInfo(name = "RUN_DISTANCE")
    val runDistance: Float

    @ColumnInfo(name = "SWIM_DISTANCE")
    val swimDistance: Float

    @ColumnInfo(name = "CALORIES")
    val calories: Float

}
