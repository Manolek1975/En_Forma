package com.delek.enforma.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resume")
data class ResumeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val exercise: Int,
    val date: String,
    val start: String,
    val end: String,
    val duration: Int
)