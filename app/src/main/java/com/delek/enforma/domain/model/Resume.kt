package com.delek.enforma.domain.model

import java.sql.Date
import java.sql.Time

class Resume(
    val id: Int,
    val date: Date,
    val start: Time,
    val end: Time,
    val duration: Time
)