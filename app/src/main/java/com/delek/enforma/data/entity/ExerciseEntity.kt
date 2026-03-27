package com.delek.enforma.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String
)