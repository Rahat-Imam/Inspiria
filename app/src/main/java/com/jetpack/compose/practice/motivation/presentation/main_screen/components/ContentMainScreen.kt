package com.jetpack.compose.practice.motivation.presentation.main_screen.components

import HorizontalViewPagerWithIndicators
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.core.enums.ExploreItems
import com.jetpack.compose.practice.motivation.navigation.NavControllerRoutes

@Composable
fun ContentMainScreen(navController: NavController, paddingValues: PaddingValues, navigateTo:(String)->Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)


    ){
        Column {
            HorizontalViewPagerWithIndicators{
                val exploreItem = when(it){
                    1 -> ExploreItems.Motivation1.name
                    2 -> ExploreItems.Motivation2.name
                    3 -> ExploreItems.Motivation3.name
                    4 -> ExploreItems.Motivation4.name
                    5 -> ExploreItems.Motivation5.name
                    else -> ExploreItems.Motivation1.name
                }
                navController.navigate(
                    NavControllerRoutes.ViewExploreScreen(
                        exploreItem = exploreItem
                    ).getPathWithNavArgs()
                )
            }
            MainAppFeatures{
                navigateTo(it)
            }
        }
    }
}
