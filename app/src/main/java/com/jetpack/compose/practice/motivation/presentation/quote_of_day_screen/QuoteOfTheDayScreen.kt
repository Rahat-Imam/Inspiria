package com.jetpack.compose.practice.motivation.presentation.quote_of_day_screen

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.jetpack.compose.practice.motivation.core.QuotesViewModel
import com.jetpack.compose.practice.motivation.R
import com.jetpack.compose.practice.motivation.core.enums.UserEvent
import com.jetpack.compose.practice.motivation.core.extension.copy
import com.jetpack.compose.practice.motivation.core.extension.share
import com.jetpack.compose.practice.motivation.core.presentation.DefaultTopAppBar
import com.jetpack.compose.practice.motivation.core.presentation.MainScreenWithBackground
import com.jetpack.compose.practice.motivation.core.receivers.DateTimeChangeListener
import com.jetpack.compose.practice.motivation.core.utils.getCurrentTime
import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import com.jetpack.compose.practice.motivation.presentation.quote_of_day_screen.components.QuoteAuthorText
import com.jetpack.compose.practice.motivation.presentation.quote_of_day_screen.viewmodel.QuoteDayViewModel
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor
import com.jetpack.compose.practice.motivation.ui.theme.PoppinsFontRegular
import org.koin.androidx.compose.inject

@SuppressLint("SimpleDateFormat")
@Composable
fun QuoteOfTheDayScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: QuotesViewModel by inject()
    val mainViewModel: QuoteDayViewModel by inject()
    mainViewModel.savedStateHandle = SavedStateHandle()
    var quoteState by remember { mutableStateOf(QuotesModel()) }
    var isFav by remember { mutableIntStateOf(0) }
    var currentTime by remember { mutableStateOf(getCurrentTime()) }

    DateTimeChangeListener {
        currentTime = getCurrentTime()
    }

    LaunchedEffect(currentTime, isFav) {
        mainViewModel.setSavedStateHandler(currentTime.first, currentTime.second)
        quoteState = mainViewModel.getQuoteOfDay()
    }


    MainScreenWithBackground(
        addScaffolding = true,
        topBar = {
            DefaultTopAppBar(R.string.quote_of_the_day) {
                navController.popBackStack()
            }
        }
    ) { paddingValues ->

        isFav = quoteState.favorite

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.quote_of_day_bg),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.size(100.dp))
                QuoteAuthorText(quote = quoteState.quote, author = quoteState.author)
                Spacer(modifier = Modifier.weight(1f))
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
                                    context.copy(quoteState.quote)
                                }
                            ),

                        ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(BackgroundColor)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(painterResource(id = R.drawable.icon_copy), contentDescription = null)
                                Spacer(modifier = Modifier.size(4.dp))
                                androidx.compose.material.Text(
                                    "Copy",
                                    fontSize = 11.sp,
                                    fontFamily = PoppinsFontRegular,
                                    textAlign = TextAlign.Center,
                                    color = Color.Black
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

                                    isFav = if (quoteState.favorite == 1) {
                                        0
                                    } else {
                                        1
                                    }
                                    viewModel.onUserEvent(
                                        UserEvent.IsBookmark(
                                            isFav,
                                            quoteState.id
                                        )
                                    )

                                }
                            ),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(BackgroundColor)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painterResource(
                                        id = if(isFav==1)
                                            R.drawable.icon_fav_selected
                                        else
                                            R.drawable.icon_fav_unselected
                                    ),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.size(4.dp))
                                androidx.compose.material.Text(
                                    "Favorite",
                                    fontSize = 11.sp,
                                    fontFamily = PoppinsFontRegular,
                                    textAlign = TextAlign.Center,
                                    color = Color.Black
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
                                    context.share(quoteState.quote)
                                }
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(BackgroundColor)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(painterResource(id = R.drawable.icon_share), contentDescription = null)
                                Spacer(modifier = Modifier.size(4.dp))
                                androidx.compose.material.Text(
                                    "Share",
                                    fontSize = 11.sp,
                                    fontFamily = PoppinsFontRegular,
                                    textAlign = TextAlign.Center,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
