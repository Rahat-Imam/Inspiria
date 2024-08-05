package com.jetpack.compose.practice.motivation.di.usecase

import com.jetpack.compose.practice.motivation.data.repo.QuotesRepositoryImpl
import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import kotlinx.coroutines.flow.Flow

class QuoteCategoriesUseCase(val repo: QuotesRepositoryImpl) {

    operator fun invoke(): Flow<List<QuotesModel>> {
        return repo.getQuotesFromDb()
    }

    operator fun invoke(category: String): Flow<List<QuotesModel>> {
        return repo.getQuotesByCategory(category).mapCategory(category)
    }
}