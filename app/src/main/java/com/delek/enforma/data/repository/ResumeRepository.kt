package com.delek.enforma.data.repository

import com.delek.enforma.data.dao.ResumeDao
import com.delek.enforma.data.entity.ResumeEntity
import javax.inject.Inject

class ResumeRepository @Inject constructor(private val resumeDao: ResumeDao) {

    suspend fun insert(resume: ResumeEntity) {
        resumeDao.insert(resume)
    }

    suspend fun getAll(): List<ResumeEntity> {
        return resumeDao.getAll()
    }
}