package com.jetpack.compose.practice.motivation.core.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jetpack.compose.practice.motivation.R

enum class MainFeatureItems(
    @DrawableRes val icon:Int,
    @StringRes val title:Int
) {

    QuoteOfDay(
        R.drawable.icon_quote,
        R.string.quote_of_the_day,
    ),
    Motivation(
        R.drawable.icon_motivation,
        R.string.motivation
    ),
    Author(
        R.drawable.icon_author,
        R.string.author
    ),
    Breathing(
        R.drawable.icon_breathing,
        R.string.breathing
    )

}