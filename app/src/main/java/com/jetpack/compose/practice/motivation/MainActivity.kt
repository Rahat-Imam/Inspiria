package com.jetpack.compose.practice.motivation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.jetpack.compose.practice.motivation.navigation.NavGraph
import com.jetpack.compose.practice.motivation.ui.theme.MotivationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkThemeValue by rememberSaveable { mutableStateOf(false) }

            MotivationTheme(
                darkTheme = darkThemeValue
            ){
                NavGraph(
                    navController = rememberNavController()
                ){
                    darkThemeValue =it
                }

            }

        }
    }
}