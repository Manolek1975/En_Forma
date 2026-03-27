package com.delek.enforma.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.enforma.data.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(advantages: List<ExerciseEntity>)

/*    @Query("UPDATE exercise SET Date = DATE('now') WHERE id = :id")
    suspend fun updateDate(id: Int)

    @Query("UPDATE exercise SET Start = TIME('now') WHERE id = :id")
    suspend fun updateTime(id: Int)*/

    @Query("SELECT * FROM exercise")
    suspend fun getAll(): List<ExerciseEntity>
}