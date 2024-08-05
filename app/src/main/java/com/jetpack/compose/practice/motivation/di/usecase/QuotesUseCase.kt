package com.jetpack.compose.practice.motivation.di.usecase

import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import com.jetpack.compose.practice.motivation.data.repo.QuotesRepositoryImpl
import kotlinx.coroutines.flow.Flow

class QuotesUseCase(val repo: QuotesRepositoryImpl) {

    operator fun invoke(): Flow<List<QuotesModel>> {
        return repo.getQuotesFromDb()
    }

}