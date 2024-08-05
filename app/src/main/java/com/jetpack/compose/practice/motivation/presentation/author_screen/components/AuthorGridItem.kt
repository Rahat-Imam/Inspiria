package com.jetpack.compose.practice.motivation.presentation.author_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.compose.practice.motivation.core.enums.AuthorItems
import com.jetpack.compose.practice.motivation.ui.theme.PoppinsFontMedium


@Composable
fun AuthorGridItem(author: AuthorItems, onItemSelected:(AuthorItems)->Unit) {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    onItemSelected(author)
                }
            ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {

        Column(
            Modifier.background(MaterialTheme.colorScheme.onSecondary).fillMaxSize()
        ) {
            Text(
                text = stringResource(id = author.authorName),
                fontSize = 12.sp,
                fontFamily = PoppinsFontMedium,
                lineHeight = 12.sp,
                maxLines = 1,
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

    }

}