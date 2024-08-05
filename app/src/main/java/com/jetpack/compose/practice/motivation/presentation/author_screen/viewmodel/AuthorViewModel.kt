package com.jetpack.compose.practice.motivation.presentation.author_screen.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jetpack.compose.practice.motivation.core.ConstantOfApp.AUTHOR_ID
import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import com.jetpack.compose.practice.motivation.di.usecase.QuoteAuthorUseCase
import com.jetpack.compose.practice.motivation.di.usecase.QuotesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import org.koin.androidx.compose.getStateViewModel

class AuthorViewModel(private val quoteAuthorUseCase: QuoteAuthorUseCase) : ViewModel() {

    lateinit var savedStateHandle: SavedStateHandle

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getQuotesOfAuthor(): Flow<List<QuotesModel>> {
        return savedStateHandle.getStateFlow(AUTHOR_ID, "")
            .flatMapLatest { author ->
                quoteAuthorUseCase(author)
            }
    }

    fun setSavedStateHandler(author: String) {
        savedStateHandle[AUTHOR_ID] = author
    }
}