package com.delek.enforma.domain.model

import com.delek.enforma.data.entity.ResumeEntity

data class Resume(
    val id: Int,
    val exercise: Int,
    val date: String,
    val startTime: String,
    val endTime: String,
    val duration: Int,
    val active: Boolean
)

fun ResumeEntity.toDomain() = Resume(id, exercise, date, startTime, endTime, duration, active)