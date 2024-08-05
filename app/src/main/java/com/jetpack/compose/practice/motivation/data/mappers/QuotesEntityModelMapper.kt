package com.jetpack.compose.practice.motivation.data.mappers

import com.jetpack.compose.practice.motivation.data.local.entities.QuotesEntity
import com.jetpack.compose.practice.motivation.di.models.QuotesModel

class QuotesEntityModelMapper : EntityModelMapper<QuotesEntity, QuotesModel> {
    override fun entityToModelMapper(entity: QuotesEntity): QuotesModel {
        return QuotesModel(
            id = entity.id,
            quote = entity.quote,
            author = entity.author,
            category = entity.category,
            date = entity.date,
            month = entity.month,
            favorite = entity.favorite
        )
    }

    override fun modelToEntityMapper(model: QuotesModel): QuotesEntity {
        return QuotesEntity(
            id = model.id,
            quote = model.quote,
            author = model.author,
            category = model.category,
            date = model.date,
            month = model.month,
            favorite = model.favorite
        )
    }
}
