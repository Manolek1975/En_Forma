package com.delek.enforma.data.repository

import com.delek.enforma.data.dao.ExerciseDao
import javax.inject.Inject

class ExerciseRepository @Inject constructor(val exerciseDao: ExerciseDao) {

    suspend fun getAll() = exerciseDao.getAll()
}

