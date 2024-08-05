package com.jetpack.compose.practice.motivation.data.mappers

interface EntityModelMapper<Entity,Model> {
    fun entityToModelMapper(entity: Entity): Model
    fun modelToEntityMapper(model: Model): Entity
}