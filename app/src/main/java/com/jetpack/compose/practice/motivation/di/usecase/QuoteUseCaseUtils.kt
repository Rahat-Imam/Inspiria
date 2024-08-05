package com.jetpack.compose.practice.motivation.di.usecase

import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import com.jetpack.compose.practice.motivation.data.repo.QuotesRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

fun Flow<List<QuotesModel>>.mapAuthor(authorName: String): Flow<List<QuotesModel>> {
    return transform { quotesList ->
        val filteredQuotes = quotesList.filter {
            it.author == authorName
        }
        emit(filteredQuotes)
    }
}


fun Flow<List<QuotesModel>>.mapCategory(categoryName: String): Flow<List<QuotesModel>> {
    return transform { quotesList ->
        val filteredQuotes = quotesList.filter {
            it.category == categoryName
        }
        emit(filteredQuotes)
    }
}

