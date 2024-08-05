package com.jetpack.compose.practice.motivation.core.enums

import androidx.annotation.StringRes
import com.jetpack.compose.practice.motivation.R



enum class CategoryItems(
    @StringRes val category:Int
) {

    Inspiration(
        R.string.inspiration
    ),

    Life(
        R.string.life
    ),

    Success(
        R.string.success
    ),

    Dreams(
        R.string.dreams
    ),

    Kindness(
        R.string.kindness
    ),

    Work(
        R.string.work
    ),

    Excellence(
        R.string.excellence
    ),

    Failure(
        R.string.failure
    ),

    Pain(
        R.string.pain
    ),

    Future(
        R.string.future
    )


}