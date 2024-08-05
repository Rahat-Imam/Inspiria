package com.jetpack.compose.practice.motivation.core.enums

import androidx.annotation.StringRes
import com.jetpack.compose.practice.motivation.R

enum class AuthorItems(
    @StringRes val authorName:Int,
    val authorFullName:String
) {

    AuthorTonyRobbins(
        R.string.author_1,
        "Tony Robbins"
    ),

    AuthorZigZiglar(
        R.string.author_2,
        "Zig Ziglar"
    ),

    AuthorNapoleonHill(
        R.string.author_3,
        "Napoleon Hill"
    ),

    AuthorJimRohn(
        R.string.author_4,
        "Jim Rohn"
    ),

    AuthorNormanVincentPeale(
        R.string.author_5_short,
        "Norman Vincent Peale"
    ),

    AuthorDaleCarnegie(
        R.string.author_6,
        "Dale Carnegie"
    ),

    AuthorLesBrown(
        R.string.author_7,
        "Les Brown"
    ),

    AuthorWayneDyer(
        R.string.author_8,
        "Wayne Dyer"
    ),

    AuthorBrianTracy(
        R.string.author_9,
        "Brian Tracy"
    ),

    AuthorHelenKeller(
        R.string.author_10,
        "Helen Keller"
    )

}