package com.jetpack.compose.practice.motivation.core.utils

import androidx.compose.ui.graphics.Color
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.THEME_VALUE
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColor
import com.jetpack.compose.practice.motivation.ui.theme.BackgroundColorDark
import com.jetpack.compose.practice.motivation.ui.theme.bottomAppBarColorDark
import com.jetpack.compose.practice.motivation.ui.theme.bottomAppBarColorLight
import com.jetpack.compose.practice.motivation.ui.theme.cardColorDark
import com.jetpack.compose.practice.motivation.ui.theme.cardColorLight
import com.jetpack.compose.practice.motivation.ui.theme.textColorDark
import com.jetpack.compose.practice.motivation.ui.theme.textColorLight
import java.util.Calendar


fun getMotivationQuotesOfViewPager(): ArrayList<String> {
    return arrayListOf<String>().apply {
        add("Believe in yourself. Stay in your own lane. There’s only one you.")  // Queen Latifah
        add("The harder the struggle, the more glorious the triumph. Self-realization demands very great struggle.")  // Swami Sivananda
        add("You just can’t beat the person who never gives up.")  // Babe Ruth
        add("In order to succeed. We must first believe that we can.")  // Nikos Kazantzakis
        add("It is not the strength of the body that counts, but the strength of the spirit.")  // J.R.R. Tolkien
    }
}




fun getMonthName(month:Int):String{
    return when(month){
        0 -> "January"
        1 -> "February"
        2 -> "March"
        3 -> "April"
        4 -> "May"
        5 -> "June"
        6 -> "July"
        7 -> "August"
        8 -> "September"
        9 -> "October"
        10 -> "November"
        11 -> "December"
        else -> "January"
    }
}

fun getCurrentTime(): Pair<Int, String> {
    val calendar = Calendar.getInstance()
    val date = calendar.get(Calendar.DAY_OF_MONTH)
    val month = getMonthName(calendar.get(Calendar.MONTH))
    return Pair(date, month)
}
