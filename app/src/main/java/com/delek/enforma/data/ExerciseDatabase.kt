package com.delek.enforma.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.enforma.data.dao.ExerciseDao
import com.delek.enforma.data.entity.ExerciseEntity

@Database(entities = [ExerciseEntity::class], version = 1)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao

}