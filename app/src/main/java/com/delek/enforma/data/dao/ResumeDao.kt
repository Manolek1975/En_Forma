package com.delek.enforma.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.delek.enforma.data.entity.ResumeEntity

@Dao
interface ResumeDao {

    @Insert
    suspend fun insert(resume: ResumeEntity)

    @Query("SELECT * FROM resume")
    suspend fun getAll(): List<ResumeEntity>


}