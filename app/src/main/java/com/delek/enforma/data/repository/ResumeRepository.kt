package com.delek.enforma.data.repository

import com.delek.enforma.data.dao.ResumeDao
import com.delek.enforma.data.entity.ResumeEntity
import com.delek.enforma.domain.model.Resume
import com.delek.enforma.domain.model.toDomain
import javax.inject.Inject

class ResumeRepository @Inject constructor(private val resumeDao: ResumeDao) {

    suspend fun insert(resume: ResumeEntity) {
        resumeDao.insert(resume)
    }

    suspend fun getAll(): List<Resume> {
        val response: List<ResumeEntity> = resumeDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getLast(): Resume {
        val response: ResumeEntity = resumeDao.getLast()
        return response.toDomain()
    }

    suspend fun getActive(): Resume? {
        val response: ResumeEntity? = resumeDao.getActive()
        return response?.toDomain()
    }

    suspend fun update(endTime: String, duration: Int, active: Boolean) {
        resumeDao.update(endTime, duration, active)
    }
}