package com.jetpack.compose.practice.motivation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.AUTHOR_NAME
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.CATEGORY_NAME
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.EXPLORE_ITEM
import com.jetpack.compose.practice.motivation.presentation.affirmations_screen.AffirmationsScreen
import com.jetpack.compose.practice.motivation.presentation.main_screen.MainScreen
import com.jetpack.compose.practice.motivation.presentation.splash_screen.SplashScreen
import com.jetpack.compose.practice.motivation.presentation.author_screen.AuthorScreen
import com.jetpack.compose.practice.motivation.presentation.author_screen.ViewAuthorQuotesScreen
import com.jetpack.compose.practice.motivation.presentation.breathing_screen.BreathingScreen
import com.jetpack.compose.practice.motivation.presentation.categories_screen.ViewQuotesScreen
import com.jetpack.compose.practice.motivation.presentation.explore_screen.ViewExploreScreen
import com.jetpack.compose.practice.motivation.presentation.motivation_screen.MotivationScreen
import com.jetpack.compose.practice.motivation.presentation.quote_of_day_screen.QuoteOfTheDayScreen
import com.jetpack.compose.practice.motivation.presentation.schedule_notifications_screen.ScheduleNotificationsScreen

@Composable
fun NavGraph(navController: NavHostController, themeChanges:(Boolean)->Unit) {

    val root = NavControllerRoutes.ROOT()

    NavHost(navController = navController, startDestination = root.route){

        composable(route = root.route) {
            SplashScreen(navController){
                themeChanges(it)
            }
        }

        composable(NavControllerRoutes.MainScreen().route){
            MainScreen(navController){
                themeChanges(it)
            }
        }

        composable(NavControllerRoutes.AuthorScreen().route){
            AuthorScreen(navController)
        }

        composable(NavControllerRoutes.BreathingScreen().route){
            BreathingScreen(navController)
        }

        composable(NavControllerRoutes.QuoteOfTheDayScreen().route){
            QuoteOfTheDayScreen(navController)
        }

        composable(NavControllerRoutes.MotivationScreen().route){
            MotivationScreen(navController)
        }

        composable(NavControllerRoutes.AffirmationsScreen().route){
            AffirmationsScreen(navController)
        }

        composable(NavControllerRoutes.ScheduleNotificationsScreen().route){
            ScheduleNotificationsScreen(navController)
        }

        viewExploreScreen(navController)

        viewQuotesScreen(navController)

        viewAuthorQuotesScreen(navController)

    }
}


fun NavGraphBuilder.viewExploreScreen(navController: NavHostController) {
    val exploreNav = NavControllerRoutes.ViewExploreScreen()
    composable(
        exploreNav.getPath(),
        arguments = exploreNav.listOfArguments
    ) { backStackEntry ->
        val exploreName = backStackEntry.arguments?.getString(EXPLORE_ITEM) ?: ""
        ViewExploreScreen(
            exploreItemName = exploreName,
            navController
//            navigateBack = {
//                navController.popBackStack()
//            }
        )
    }
}

fun NavGraphBuilder.viewQuotesScreen(navController: NavHostController){
    val categoryNav = NavControllerRoutes.ViewQuotesScreen()
    composable(
        categoryNav.getPath(),
        arguments = categoryNav.listOfArguments
    ) { backStackEntry ->
        val categoryName = backStackEntry.arguments?.getString(CATEGORY_NAME) ?: ""
        ViewQuotesScreen(
            categoryName = categoryName,
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.viewAuthorQuotesScreen(navController: NavHostController){
    val authorNav = NavControllerRoutes.ViewAuthorQuotesScreen()
    composable(
        authorNav.getPath(),
        arguments = authorNav.listOfArguments
    ) { backStackEntry ->
        val authorName = backStackEntry.arguments?.getString(AUTHOR_NAME) ?: ""
        ViewAuthorQuotesScreen(
            authorName = authorName,
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}