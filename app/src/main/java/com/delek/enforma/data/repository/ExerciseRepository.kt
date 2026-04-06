package com.delek.enforma.data.repository

import com.delek.enforma.data.dao.ExerciseDao
import com.delek.enforma.data.entity.ExerciseEntity
import com.delek.enforma.domain.model.Exercise
import com.delek.enforma.domain.model.toDomain
import javax.inject.Inject

class ExerciseRepository @Inject constructor(val exerciseDao: ExerciseDao) {

    suspend fun insertExercises(exercises: List<ExerciseEntity>) {
        exerciseDao.insert(exercises)
    }

    suspend fun getAll(): List<Exercise> {
        val response: List<ExerciseEntity> = exerciseDao.getAll()
        return response.map { it.toDomain() }
    }
}

