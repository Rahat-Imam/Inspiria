package com.jetpack.compose.practice.motivation.core.enums

import androidx.annotation.DrawableRes
import com.jetpack.compose.practice.motivation.R


enum class MotivationItems(
    @DrawableRes val icon:Int,
    val point1:String,
    val point2:String?,
    val point3:String?,
    val point4:String?,
    val link:String
) {

    Article1(
        R.drawable.icon_article,
        "Sources of Motivation",
        "How to Set and Accomplish Goals",
        "How to Increase Motivation",
        "Diet Exercise, and Finance Goals",
        "https://www.psychologytoday.com/us/basics/motivation#"
    ),

    Article2(
        R.drawable.icon_article,
        "What Motivation Is and How Motivation Works",
        "How to Get Motivated and Take Action",
        "How to Stay Motivated for the Long-Run",
        null,
        "https://jamesclear.com/motivation"
    ),


    Article3(
        R.drawable.icon_article,
        "15 Tips to Get Motivated on Your Own",
        "Understanding Causes Lack of Motivation",
        "Think of the end rather than the beginning",
        null,
        "https://everydaypower.com/15-simple-ways-to-get-motivated-when-you-are-alone/"
    ),

    Article4(
        R.drawable.icon_article,
        "10 Inspirational Stories to Develop Empathy, Critical Thinking, and Heightened Perspective",
        null, null,null,
        "https://leaders.com/articles/books/short-motivational-stories/"
    )
}