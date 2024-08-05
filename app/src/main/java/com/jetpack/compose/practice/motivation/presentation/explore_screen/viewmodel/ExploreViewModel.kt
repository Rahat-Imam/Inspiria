package com.jetpack.compose.practice.motivation.presentation.explore_screen.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpack.compose.practice.motivation.di.usecase.QuotesUseCase

class ExploreViewModel : ViewModel() {
    private var _onBitmapCreated = MutableLiveData<Bitmap?>(null)
    var onBitmapGenerated: LiveData<Bitmap?> = _onBitmapCreated

    fun bitmapCreated(bitmap: Bitmap?) {
        _onBitmapCreated.value = bitmap
    }
}