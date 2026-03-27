package com.delek.enforma.domain.model

import com.delek.enforma.data.entity.ExerciseEntity

data class Exercise(
    val id: Int,
    val name: String,
    val image: String
)

fun ExerciseEntity.toDomain() = Exercise(id, name, image)
