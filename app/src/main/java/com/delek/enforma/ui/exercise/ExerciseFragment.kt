package com.delek.enforma.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.delek.enforma.R
import com.delek.enforma.databinding.FragmentExerciseBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseFragment : Fragment() {

    private val  exerciseViewModel by viewModels<ExerciseViewModel>()
    private var _binding: FragmentExerciseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI() {
        setMenuVisible()
        navigation()

    }

    private fun setMenuVisible() {
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view.visibility = View.VISIBLE
    }

    private fun navigation() {

        binding.ibFooting.setOnClickListener {
            findNavController().navigate(
                ExerciseFragmentDirections.Companion.actionExerciseFragmentToFormFragment("Footing")
            )
        }
        binding.ibGym.setOnClickListener {
            findNavController().navigate(
                ExerciseFragmentDirections.Companion.actionExerciseFragmentToFormFragment("Gym")
            )
        }
        binding.ibWeight.setOnClickListener {
            findNavController().navigate(
                ExerciseFragmentDirections.Companion.actionExerciseFragmentToFormFragment("Weight")
            )
        }
        binding.ibBicycle.setOnClickListener {
            findNavController().navigate(
                ExerciseFragmentDirections.Companion.actionExerciseFragmentToFormFragment("Bicycle")
            )
        }
    }
}