package com.example.golftracker.data.db

import androidx.room.*
import com.example.golftracker.data.model.BallLocation

@Dao
interface BallDao {
    @Insert
    suspend fun insert(ballLocation: BallLocation)

    @Query("SELECT * FROM BallLocation ORDER BY timestamp DESC")
    suspend fun getAll(): List<BallLocation>
}

