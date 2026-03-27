package com.delek.enforma.ui.exercise

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor() : ViewModel(){

    fun getExercise() {
        //listOf(Footing, Gym, Weight, Bicycle)
    }
}