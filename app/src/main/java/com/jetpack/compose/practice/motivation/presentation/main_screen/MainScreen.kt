package com.jetpack.compose.practice.motivation.presentation.main_screen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Left
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Right
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat.recreate
import androidx.navigation.NavHostController
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.THEME_VALUE
import com.jetpack.compose.practice.motivation.core.QuotesViewModel
import com.jetpack.compose.practice.motivation.core.enums.BottomNavItems
import com.jetpack.compose.practice.motivation.core.enums.DrawerItems
import com.jetpack.compose.practice.motivation.core.enums.Theme
import com.jetpack.compose.practice.motivation.presentation.main_screen.components.HomeScreen
import com.jetpack.compose.practice.motivation.presentation.categories_screen.CategoriesScreen
import com.jetpack.compose.practice.motivation.presentation.explore_screen.ExploreScreen
import com.jetpack.compose.practice.motivation.presentation.favorite_screen.FavouriteScreen
import com.jetpack.compose.practice.motivation.presentation.main_screen.components.BottomNavBarMainScreen
import com.jetpack.compose.practice.motivation.core.presentation.DefaultTopAppBar
import com.jetpack.compose.practice.motivation.core.presentation.MainScreenWithBackground
import com.jetpack.compose.practice.motivation.core.presentation.TopAppBarMainScreen
import com.jetpack.compose.practice.motivation.core.utils.Preferences
import com.jetpack.compose.practice.motivation.presentation.main_screen.components.DrawerContent
import com.jetpack.compose.practice.motivation.presentation.main_screen.components.ThemeDialog
import com.jetpack.compose.practice.motivation.ui.theme.MotivationTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.inject
import kotlin.system.exitProcess

@Composable
fun MainScreen(navController: NavHostController, changeTheme:(Boolean)->Unit) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedScreen by rememberSaveable { mutableStateOf(BottomNavItems.Home) }
    val coroutineScope = rememberCoroutineScope()
    var showThemeDialog by remember { mutableStateOf(false) }
    val prefs:Preferences by inject()


    BackHandler {
        if(selectedScreen!= BottomNavItems.Home){
            selectedScreen = BottomNavItems.Home
        }
        else {
            exitProcess(1)
        }
    }


    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(
                onItemSelected = { item ->
                    when(item){
                        DrawerItems.Theme -> { showThemeDialog = true }
                        DrawerItems.EnableNotification -> showThemeDialog=false
                        DrawerItems.ScheduleNotification -> navController.navigate("ScheduleNotificationsScreen")
                        DrawerItems.Affirmations -> navController.navigate("AffirmationsScreen")
                    }
                    // Handle drawer item click
                    coroutineScope.launch {
                        drawerState.close()
                    }
                    Log.d("DrawerItem", "Selected: $item")
                }
            )
        },
        drawerState = drawerState,
        gesturesEnabled = true
    ){
        MainScreenWithBackground(
            addScaffolding = true,
            topBar = {
                if(selectedScreen == BottomNavItems.Home){
                    TopAppBarMainScreen{
                        coroutineScope.launch { drawerState.open() }
                    }
                }
                else{
                    DefaultTopAppBar(title = selectedScreen.navName) {
                        selectedScreen = BottomNavItems.Home
                    }
                }

            },
            bottomBar = {
                BottomNavBarMainScreen(
                    selectedScreen = selectedScreen,
                    onItemClick = {
                        selectedScreen = it
                    }
                )
            })
        { paddingValues ->

            AnimatedContent(
                targetState = selectedScreen,
                transitionSpec = {
                    slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = Right
                    ).togetherWith(
                        slideOutOfContainer(
                            animationSpec = tween(300, easing = EaseOut),
                            towards = Left
                        )
                    )
                },
                label = "Bottom Nav Items")
            { targetState ->
                when (targetState) {
                    BottomNavItems.Home -> {
                        HomeScreen(navController = navController, paddingValues)
                    }
                    BottomNavItems.Explore -> {
                        ExploreScreen(navController = navController, paddingValues)
                    }
                    BottomNavItems.Categories -> {
                        CategoriesScreen(navController = navController, paddingValues)
                    }
                    BottomNavItems.Favorites -> {
                        FavouriteScreen(navController = navController, paddingValues)
                    }
                }
            }

            ThemeDialog(
                openDialog = showThemeDialog,
                onDismiss = {
                    showThemeDialog = false
                },
                onConfirm = { it->
                    showThemeDialog = false
                    when(it){
                        Theme.Light.name ->{
                            coroutineScope.launch {
                                prefs.setIsDarkTheme(false)
                            }
                            changeTheme(false)
                        }
                        Theme.Dark.name -> {
                            coroutineScope.launch {
                                prefs.setIsDarkTheme(true)
                            }
                            changeTheme(true)
                        }
                    }
                }
            )

        }
    }

}
