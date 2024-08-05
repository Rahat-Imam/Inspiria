package com.jetpack.compose.practice.motivation.presentation.affirmations_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jetpack.compose.practice.motivation.core.presentation.DefaultTopAppBar
import com.jetpack.compose.practice.motivation.core.presentation.MainScreenWithBackground
import com.jetpack.compose.practice.motivation.presentation.affirmations_screen.components.ViewPagerAffirmations

@Composable
fun AffirmationsScreen(navController: NavHostController) {

    MainScreenWithBackground(
        addScaffolding = true,
        topBar = {
            DefaultTopAppBar("Affirmations"){
                navController.popBackStack()
            }
        }
    ){ paddingValues->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            ViewPagerAffirmations()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAffirmations(){
    AffirmationsScreen(rememberNavController())
}