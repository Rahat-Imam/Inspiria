package com.jetpack.compose.practice.motivation.di.usecase

import com.jetpack.compose.practice.motivation.data.repo.QuotesRepositoryImpl
import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import kotlinx.coroutines.flow.Flow

class QuoteAuthorUseCase(val repo: QuotesRepositoryImpl) {

    operator fun invoke(): Flow<List<QuotesModel>> {
        return repo.getQuotesFromDb()
    }

    operator fun invoke(author: String): Flow<List<QuotesModel>> {
        return repo.getQuotesOfAuthor(author).mapAuthor(author)
    }
}