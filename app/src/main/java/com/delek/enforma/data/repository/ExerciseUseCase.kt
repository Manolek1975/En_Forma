package com.delek.enforma.data.repository

import javax.inject.Inject

class ExerciseUseCase @Inject constructor(val exerciseRepository: ExerciseRepository) {

    suspend fun getAll() = exerciseRepository.getAll()

}