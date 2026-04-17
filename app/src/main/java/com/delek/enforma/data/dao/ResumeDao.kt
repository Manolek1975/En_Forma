package com.delek.enforma.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.enforma.data.entity.ResumeEntity

@Dao
interface ResumeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(resume: ResumeEntity)

    @Query("SELECT * FROM resume")
    suspend fun getAll(): List<ResumeEntity>

    @Query("SELECT * FROM resume ORDER BY id DESC LIMIT 1")
    suspend fun getLast(): ResumeEntity

    @Query("SELECT * FROM resume WHERE active = 1")
    suspend fun getActive(): ResumeEntity?

    @Query("UPDATE resume SET endTime = :endTime, duration = :duration, active = :active " +
            "WHERE id = (SELECT id FROM resume ORDER BY id DESC LIMIT 1)")
    suspend fun update(endTime: String, duration: Int, active: Boolean)

}