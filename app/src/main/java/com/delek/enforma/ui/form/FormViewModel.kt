package com.delek.enforma.ui.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.enforma.data.repository.ExerciseRepository
import com.delek.enforma.domain.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val repository: ExerciseRepository) : ViewModel(){

    val exercise = MutableLiveData<Exercise>()

    fun getExerciseById(id: Int) {
        viewModelScope.launch {
            exercise.value = repository.getExerciseById(id)
        }
    }

}