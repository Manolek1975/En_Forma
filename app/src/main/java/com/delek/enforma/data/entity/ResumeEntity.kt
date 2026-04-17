package com.delek.enforma.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resume")
data class ResumeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val exerciseId: Int,
    val name: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val duration: Int,
    val active: Boolean
)