package com.jetpack.compose.practice.motivation.core.utils


sealed interface UiStates<out T> {
    data object Loading: UiStates<Nothing>
    data class Success<T>(var template: T): UiStates<T>
}


