package com.delek.enforma.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.enforma.data.repository.ExerciseUseCase
import com.delek.enforma.domain.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val exerciseUseCase: ExerciseUseCase) : ViewModel(){

    val exerciseList = MutableLiveData<Exercise>()

    fun onCreate() {
        viewModelScope.launch {
            val exercise = exerciseUseCase()
            if (exercise.isNotEmpty()) {
                exerciseList.postValue(exercise[0])
            }
        }
    }

}