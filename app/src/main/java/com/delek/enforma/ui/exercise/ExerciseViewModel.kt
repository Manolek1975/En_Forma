package com.delek.enforma.ui.exercise

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.enforma.data.repository.ExerciseRepository
import com.delek.enforma.domain.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(private val repository: ExerciseRepository) : ViewModel(){

    val exercise = MutableLiveData<List<Exercise>>()

    init {
        viewModelScope.launch {
            exercise.value = repository.getAll()
        }
    }

    fun getExercise() {
        //listOf(Footing, Gym, Weight, Bicycle)
    }
}