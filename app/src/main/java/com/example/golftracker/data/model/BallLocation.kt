package com.example.golftracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BallLocation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val lat: Double,
    val lng: Double,
    val timestamp: Long
)

data class HoleMarker(
    val number: Int,
    val latLng: com.google.android.gms.maps.model.LatLng
)

