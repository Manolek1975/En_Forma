package com.delek.enforma.domain.model

import com.delek.enforma.data.entity.ResumeEntity

data class Resume(
    val id: Int,
    val exercise: Int,
    val date: String,
    val start: String,
    val end: String,
    val duration: Int
)

fun ResumeEntity.toDomain() = Resume(id, exercise, date, start, end, duration)