package com.example.golftracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.golftracker.presentation.CourseMapScreen
import com.example.golftracker.ui.theme.GolfTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GolfTrackerTheme {
                CourseMapScreen()
            }
        }
    }
}

