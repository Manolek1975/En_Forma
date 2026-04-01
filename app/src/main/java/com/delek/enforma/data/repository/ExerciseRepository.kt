package com.delek.enforma.data.repository

import com.delek.enforma.data.dao.ExerciseDao
import com.delek.enforma.data.entity.ExerciseEntity
import javax.inject.Inject

class ExerciseRepository @Inject constructor(val exerciseDao: ExerciseDao) {

    suspend fun insertExercises(exercises: List<ExerciseEntity>) {
        exerciseDao.insert(exercises)
    }
    suspend fun getAll() = exerciseDao.getAll()
}

