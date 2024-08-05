package com.jetpack.compose.practice.motivation.core.presentation

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.compose.practice.motivation.R
import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import com.jetpack.compose.practice.motivation.core.QuotesViewModel
import com.jetpack.compose.practice.motivation.core.enums.UserEvent
import com.jetpack.compose.practice.motivation.core.extension.copy
import com.jetpack.compose.practice.motivation.core.extension.share
import com.jetpack.compose.practice.motivation.ui.theme.AppMainColor
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor
import com.jetpack.compose.practice.motivation.ui.theme.PoppinsFontRegular
import org.koin.androidx.compose.inject


@Composable
fun ViewQuoteItems(quotesMC: QuotesModel, showAuthorName:Boolean=true) {
    val viewModel: QuotesViewModel by inject()
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 5.dp, 20.dp, 5.dp)
            .clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {}
            ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {

        Column(
            Modifier
                .background(MaterialTheme.colorScheme.onPrimary)
                .fillMaxSize()
                .padding(10.dp, 15.dp, 10.dp, 15.dp)
        ) {
            Text(
                text = "\"${quotesMC.quote}\"",
                fontSize = 13.sp,
                fontFamily = PoppinsFontRegular,
                lineHeight = 15.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .padding(30.dp, 5.dp, 30.dp, 5.dp)
                    .align(Alignment.CenterHorizontally)
            )
            if(showAuthorName){
                Text(
                    text = quotesMC.author,
                    fontSize = 12.sp,
                    fontFamily = PoppinsFontRegular,
                    lineHeight = 12.sp,
                    maxLines = 1,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(30.dp, 5.dp, 30.dp, 5.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.size(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .padding(5.dp)
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                context.copy(quotesMC.quote)
                            }
                        ),

                    ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(painterResource(
                                id = R.drawable.icon_copy),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(
                                "Copy",
                                fontSize = 11.sp,
                                fontFamily = PoppinsFontRegular,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .padding(5.dp)
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                val updatedValue = if(quotesMC.favorite == 1){ 0 } else{ 1 }
                                viewModel.onUserEvent(UserEvent.IsBookmark(updatedValue, quotesMC.id))
                            }
                        ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painterResource(
                                    id = if(quotesMC.favorite==1)
                                        R.drawable.icon_fav_selected
                                    else
                                        R.drawable.icon_fav_unselected
                                ),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(
                                "Favorite",
                                fontSize = 11.sp,
                                fontFamily = PoppinsFontRegular,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .padding(5.dp)
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                context.share(quotesMC.quote)
                            }
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(painterResource(id = R.drawable.icon_share),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary))
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(
                                "Share",
                                fontSize = 11.sp,
                                fontFamily = PoppinsFontRegular,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
            }

        }
    }
}

