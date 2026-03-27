package com.delek.enforma.data.provider


import android.content.Context
import com.delek.enforma.R
import com.delek.enforma.data.entity.ExerciseEntity


class ExerciseProvider() {

    companion object{
        fun loadExercises(context: Context): List<ExerciseEntity> {
            val exercises: MutableList<ExerciseEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_exercise)
            val image = context.resources.getStringArray(R.array.image_exercise)
            for (i in name.indices) {
                val data = ExerciseEntity(i + 1, name[i], image[i])
                exercises.add(data)
            }
            return exercises
        }
    }

}