package com.example.golftracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.golftracker.data.db.BallRepository
import com.example.golftracker.data.model.BallLocation
import com.example.golftracker.data.model.HoleMarker
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val ballRepo: BallRepository
) : ViewModel() {

    fun getHoleMarkers(): List<HoleMarker> {
        return listOf(
            HoleMarker(1, LatLng(37.4219983, -122.084)),
            HoleMarker(2, LatLng(37.422, -122.086)),
            HoleMarker(3, LatLng(37.423, -122.087))
        )
    }

    fun saveBallLocation(latLng: LatLng) {
        viewModelScope.launch {
            ballRepo.insertBallLocation(BallLocation(0, latLng.latitude, latLng.longitude, System.currentTimeMillis()))
        }
    }
}

