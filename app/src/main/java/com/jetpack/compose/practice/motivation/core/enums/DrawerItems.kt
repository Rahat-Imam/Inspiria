package com.jetpack.compose.practice.motivation.core.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jetpack.compose.practice.motivation.R


enum class DrawerItems(
    @DrawableRes val icon:Int,
    val itemName:String
) {
    Theme(
        R.drawable.icon_home_selected,
        "Theme"
    ),
    EnableNotification(
        R.drawable.icon_explore_selected,
        "Enable Notification"
    ),
    ScheduleNotification(
        R.drawable.icon_categories_selected,
        "Schedule Notification"
    ),
    Affirmations(
        R.drawable.icon_favorite_selected,
        "Affirmations"
    )
}