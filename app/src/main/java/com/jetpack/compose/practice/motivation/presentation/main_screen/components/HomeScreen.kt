package com.jetpack.compose.practice.motivation.presentation.main_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.core.enums.MainFeatureItems

@Composable
fun HomeScreen(navController: NavController, paddingValues : PaddingValues) {
    ContentMainScreen(navController ,paddingValues){
        navController.navigate(
            when(it){
                MainFeatureItems.QuoteOfDay.name -> "QuoteOfTheDayScreen"
                MainFeatureItems.Motivation.name -> "MotivationScreen"
                MainFeatureItems.Author.name -> "AuthorScreen"
                MainFeatureItems.Breathing.name -> "BreathingScreen"
                else -> "MainScreen"
            }
        )
    }
}