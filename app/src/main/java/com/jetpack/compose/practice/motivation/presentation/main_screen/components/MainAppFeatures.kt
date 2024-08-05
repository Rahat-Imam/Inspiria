package com.jetpack.compose.practice.motivation.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.compose.practice.motivation.core.enums.MainFeatureItems
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor
import com.jetpack.compose.practice.motivation.ui.theme.PoppinsFontMedium
import com.jetpack.compose.practice.motivation.ui.theme.cardColorDark
import com.jetpack.compose.practice.motivation.ui.theme.cardColorLight


@Composable
fun MainAppFeatures(onItemSelected:(String)->Unit) {
    Box{
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // You can use GridCells.Adaptive(150.dp) for adaptive grid
            modifier = Modifier.padding(10.dp),
            content = {
                items(MainFeatureItems.entries.size) { it->
                    GridItem(MainFeatureItems.entries[it]){
                        onItemSelected(it)
                    }
                }
            }
        )
    }
}

@Composable
fun GridItem(feature: MainFeatureItems, onItemSelected:(String)->Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        onClick = {
            onItemSelected(feature.name)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onSecondary),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(feature.icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                )
                Text(
                    text = stringResource(id = feature.title),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 13.sp,
                    fontFamily = PoppinsFontMedium,
                    lineHeight = 23.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewMyGridView() {
//    MainAppFeatures()
//}
