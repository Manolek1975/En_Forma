package com.delek.enforma.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.enforma.R
import com.delek.enforma.databinding.FragmentExerciseBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExerciseFragment : Fragment() {

    private val viewModel: ExerciseViewModel by viewModels()
    private var _binding: FragmentExerciseBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ExerciseAdapter


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
        adapter = ExerciseAdapter(onItemSelected = {
            findNavController().navigate(
                ExerciseFragmentDirections.actionExerciseFragmentToFormFragment(it.id)
            )
        })
        binding.rvExercises.layoutManager = GridLayoutManager(context, 2)
        binding.rvExercises.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.exercise.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                }
            }
        }
    }

}