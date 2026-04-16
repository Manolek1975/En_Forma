package com.delek.enforma.ui.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.enforma.data.entity.ResumeEntity
import com.delek.enforma.data.repository.ExerciseRepository
import com.delek.enforma.data.repository.ResumeRepository
import com.delek.enforma.domain.model.Exercise
import com.delek.enforma.domain.model.Resume
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val repository: ExerciseRepository,
    private val resumeRepository: ResumeRepository
) : ViewModel() {

    val exercise = MutableLiveData<Exercise>()
    val resume = MutableLiveData<Resume>()


    fun getExerciseById(id: Int) {
        viewModelScope.launch {
            exercise.value = repository.getExerciseById(id)
        }
    }

    fun insertResume(resume: ResumeEntity) {
        viewModelScope.launch {
            resumeRepository.insert(resume)
        }
    }

    fun getLast() {
        viewModelScope.launch {
            resume.value = resumeRepository.getLast()
        }
    }

    fun updateActive(endTime: String, duration: Int, active: Boolean) {
        viewModelScope.launch {
            resumeRepository.update(endTime, duration, active)
        }

    }

}