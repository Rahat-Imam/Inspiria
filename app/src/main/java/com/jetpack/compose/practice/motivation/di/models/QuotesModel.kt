package com.jetpack.compose.practice.motivation.di.models

data class QuotesModel(
    val id:Int = 0,
    val quote:String = "",
    val author:String = "",
    val category:String = "",
    val date:Int = 0,
    val month:String = "",
    val favorite:Int = 0
)