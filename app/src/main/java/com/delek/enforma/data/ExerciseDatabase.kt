package com.delek.enforma.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.enforma.data.dao.ExerciseDao
import com.delek.enforma.data.dao.ResumeDao
import com.delek.enforma.data.entity.ExerciseEntity
import com.delek.enforma.data.entity.ResumeEntity

@Database(entities =
    [ExerciseEntity::class, ResumeEntity::class], version = 1)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun getExerciseDao(): ExerciseDao
    abstract fun getResumeDao(): ResumeDao

}