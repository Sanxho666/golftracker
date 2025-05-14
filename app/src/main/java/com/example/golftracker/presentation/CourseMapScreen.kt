package com.example.golftracker.presentation

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.golftracker.viewmodel.MapViewModel
import com.example.golftracker.data.model.HoleMarker
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMapViewWithLifecycle

@Composable
fun CourseMapScreen(viewModel: MapViewModel = hiltViewModel()) {
    val mapView = rememberMapViewWithLifecycle()
    val context = LocalContext.current

    AndroidView(factory = { mapView }) { view ->
        mapView.getMapAsync { map ->
            map.uiSettings.isZoomControlsEnabled = true
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                map.isMyLocationEnabled = true
            }

            viewModel.getHoleMarkers().forEach { hole ->
                map.addMarker(MarkerOptions()
                    .position(hole.latLng)
                    .title("Hole ${hole.number}")
                )
            }

            map.setOnMapClickListener { latLng ->
                viewModel.saveBallLocation(latLng)
                map.addMarker(MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                    .title("Ball Position")
                )
            }
        }
    }
}

