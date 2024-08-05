package com.jetpack.compose.practice.motivation.core.enums

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.jetpack.compose.practice.motivation.R

enum class Theme(
    @DrawableRes val icon:Int,
    val itemName:String,
    val background:Color,
    val textColor:Color
) {
    Light(
        R.drawable.icon_home_selected,
        "Theme",
        background = Color.White,
        textColor = Color.Black
    ),
    Dark(
        R.drawable.icon_home_selected,
        "Theme",
        background = Color.DarkGray,
        textColor = Color.White
    )
}