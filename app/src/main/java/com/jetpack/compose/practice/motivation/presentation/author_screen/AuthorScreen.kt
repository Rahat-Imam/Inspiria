package com.jetpack.compose.practice.motivation.presentation.author_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.R
import com.jetpack.compose.practice.motivation.core.enums.AuthorItems
import com.jetpack.compose.practice.motivation.core.presentation.DefaultTopAppBar
import com.jetpack.compose.practice.motivation.core.presentation.MainScreenWithBackground
import com.jetpack.compose.practice.motivation.navigation.NavControllerRoutes
import com.jetpack.compose.practice.motivation.presentation.author_screen.components.AuthorGridItem
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor

@Composable
fun AuthorScreen(navController: NavController) {

    MainScreenWithBackground(
        addScaffolding = true,
        topBar = {

            DefaultTopAppBar(R.string.author) {
                navController.popBackStack()
            }
        }
    ){ paddingValues->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(5.dp),
                content = {
                    items(AuthorItems.entries.size) {
                        AuthorGridItem(AuthorItems.entries[it]){
                            navController.navigate(
                                NavControllerRoutes.ViewAuthorQuotesScreen(
                                    author = it.authorFullName
                                ).getPathWithNavArgs()
                            )
                        }
                    }
                }
            )
        }
    }
}

