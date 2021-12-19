package com.example.shiftkeyapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shiftkeyapp.ui.shiftdetails.ShiftDetailsScreen
import com.example.shiftkeyapp.ui.shiftlist.ShiftsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController, startDestination = "shifts_screen"
            ) {
                composable("shifts_screen") {
                    ShiftsScreen(navController = navController)
                }
                composable("shift_details_screen") {
                    ShiftDetailsScreen(
                        navController = navController
                    )
                }
            }
        }
    }
}
