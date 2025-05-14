package com.example.golftracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.golftracker.data.model.BallLocation

@Database(entities = [BallLocation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ballDao(): BallDao
}

