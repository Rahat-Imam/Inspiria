package com.jetpack.compose.practice.motivation.presentation.categories_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.core.enums.CategoryItems
import com.jetpack.compose.practice.motivation.navigation.NavControllerRoutes
import com.jetpack.compose.practice.motivation.presentation.categories_screen.components.CategoriesGridItem

@Composable
fun CategoriesScreen(navController: NavController, paddingValues : PaddingValues) {

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ){

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(5.dp),
            content = {
                items(CategoryItems.entries.size) { it->
                    CategoriesGridItem(CategoryItems.entries[it]){
                        navController.navigate(
                            NavControllerRoutes.ViewQuotesScreen(
                                category = it.name
                            ).getPathWithNavArgs()
                        )
                    }
                }
            }
        )

    }
}