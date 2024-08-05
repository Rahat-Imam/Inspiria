import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.jetpack.compose.practice.motivation.R
import com.jetpack.compose.practice.motivation.core.enums.ExploreItems
import com.jetpack.compose.practice.motivation.core.utils.getMotivationQuotesOfViewPager
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor
import com.jetpack.compose.practice.motivation.ui.theme.PoppinsFontMedium
import com.jetpack.compose.practice.motivation.navigation.NavControllerRoutes

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalViewPagerWithIndicators(onItemClicked : (Int) -> Unit) {
    val pagerState = rememberPagerState()
    val listOfMotivationalQuotes = getMotivationQuotesOfViewPager()

    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(3000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(340.dp)

    ) {
        HorizontalPager(
            count = 5,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)

        ) { page ->
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier =
                Modifier
                    .padding(10.dp, 10.dp, 10.dp, 10.dp)
                    .clickable(indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            onItemClicked(page+1)
                        }
                    )
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize())
                {
                    Image(
                        painter =
                        painterResource(id = R.drawable.view_pager),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = listOfMotivationalQuotes.get(index = page),
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = PoppinsFontMedium,
                        lineHeight = 23.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(10.dp)
                    )
                }

            }

        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp, 16.dp, 16.dp, 40.dp),
            activeColor = Color.White,
            inactiveColor = Color.LightGray,
            indicatorWidth = 10.dp,
            spacing = 8.dp
        )
    }
}

