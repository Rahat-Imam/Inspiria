package com.jetpack.compose.practice.motivation.presentation.motivation_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.R
import com.jetpack.compose.practice.motivation.core.enums.MotivationItems
import com.jetpack.compose.practice.motivation.core.presentation.DefaultTopAppBar
import com.jetpack.compose.practice.motivation.core.presentation.MainScreenWithBackground
import com.jetpack.compose.practice.motivation.presentation.motivation_screen.components.MotivationGridItem
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor


@Composable
fun MotivationScreen(navController: NavController) {

    val context = LocalContext.current
    MainScreenWithBackground(
        addScaffolding = true,
        topBar = {

            DefaultTopAppBar(R.string.motivation) {
                navController.popBackStack()
            }
        }
    ){ paddingValues->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                content = {
                    items(MotivationItems.entries.size) {
                        MotivationGridItem(MotivationItems.entries[it], context){}
                    }
                }
            )
        }
    }

}
