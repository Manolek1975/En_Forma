package com.delek.enforma.data.repository

import android.content.Context
import com.delek.enforma.data.provider.ExerciseProvider
import com.delek.enforma.domain.model.Exercise
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ExerciseUseCase @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val exerciseRepository: ExerciseRepository
) {

    suspend operator fun invoke(): List<Exercise> {
        val exercises = exerciseRepository.getAll()
        return if (exercises.isEmpty()) {
            exerciseRepository.insertExercises(ExerciseProvider.loadExercises(context))
            exercises
        } else {
            exerciseRepository.getAll()
        }
    }

}