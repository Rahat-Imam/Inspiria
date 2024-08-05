package com.jetpack.compose.practice.motivation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.THEME_VALUE
import com.jetpack.compose.practice.motivation.core.enums.Theme
import com.jetpack.compose.practice.motivation.core.utils.Preferences
import com.jetpack.compose.practice.motivation.presentation.main_screen.components.BottomNavBarMainScreen
import kotlinx.coroutines.flow.first
import org.koin.androidx.compose.inject

// Light theme colors
private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    primaryContainer = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5),
    secondaryContainer = Color(0xFF03DAC5),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFCF6679),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF000000),
    onError = Color(0xFFFFFFFF)
)

// Dark theme colors
private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    primaryContainer = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6),
    secondaryContainer = Color(0xFF018786),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    error = Color(0xFFCF6679),
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
    onError = Color(0xFF000000)
)

//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40,
//    background = Theme.Light.background,
//)
//
//private val DarkColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40,
//    background = Theme.Dark.background
//)


private val DarkColorScheme = darkColorScheme(
    primary = AppMainColorDark,
    onPrimary = Color(0xFF000000),
    onPrimaryContainer = Color(0xFFFFFFFF),
    secondary = PurpleGrey80,
    onSecondary = cardColorDark,
    onSecondaryContainer = textColorDark,
    tertiary = Pink80,
    onTertiary = bottomAppBarColorDark,
    background = BackgroundColorDark,
    onBackground = Color.LightGray
)

private val LightColorScheme = lightColorScheme(
    primary = AppMainColor,
    onPrimary = Color(0xFFFFFFFF),
    onPrimaryContainer = Color(0xFF000000),
    secondary = PurpleGrey40,
    onSecondary = cardColorLight,
    onSecondaryContainer = textColorLight,
    tertiary = Pink40,
    onTertiary = bottomAppBarColorLight,
    background = BackgroundColor,
    onBackground = Color.DarkGray

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)


@Composable
fun MotivationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !darkTheme
    val statusBarColor = colorScheme.onPrimary

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }


    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}