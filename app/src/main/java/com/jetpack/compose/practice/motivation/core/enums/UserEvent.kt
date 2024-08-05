package com.jetpack.compose.practice.motivation.core.enums

sealed interface UserEvent {
    data class IsBookmark(val bookMarkValue: Int, val id: Int) : UserEvent
}