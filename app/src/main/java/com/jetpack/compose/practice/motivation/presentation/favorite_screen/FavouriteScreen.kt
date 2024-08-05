package com.jetpack.compose.practice.motivation.presentation.favorite_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.core.QuotesViewModel
import com.jetpack.compose.practice.motivation.core.presentation.Loading
import com.jetpack.compose.practice.motivation.core.presentation.ViewQuoteItems
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor
import com.jetpack.compose.practice.motivation.ui.theme.PoppinsFontMedium
import com.jetpack.compose.practice.motivation.core.utils.UiStates
import org.koin.androidx.compose.inject

@Composable
fun FavouriteScreen(navController: NavController, paddingValues : PaddingValues) {

    val viewModel: QuotesViewModel by inject()

    val quotes by viewModel.getAllFavQuotes.collectAsStateWithLifecycle()

    when (quotes) {
        UiStates.Loading -> Loading(modifier = Modifier.fillMaxSize())
        is UiStates.Success -> {
            val list = (quotes as UiStates.Success).template

            if(list.size == 0){
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "No Fav Item Found!",
                        fontFamily = PoppinsFontMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                }
            }
            else{
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    ) {
                        items(list.size) { item ->
                            ViewQuoteItems(list[item])
                        }
                    }

                }
            }

        }
    }
}

