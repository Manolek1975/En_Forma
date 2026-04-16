package com.delek.enforma.ui.resume

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.enforma.data.repository.ResumeRepository
import com.delek.enforma.domain.model.Resume
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResumeViewModel @Inject constructor(private val repository: ResumeRepository) : ViewModel() {

    val resume = MutableLiveData<List<Resume>>()

    fun getAll() {
        viewModelScope.launch {
            resume.value = repository.getAll()
        }
    }
}