package com.delek.enforma.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.delek.enforma.R
import com.delek.enforma.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initUI()
        hideMenu()
        return binding.root
    }

    private fun initUI() {
        binding.root.setOnClickListener {
            findNavController().navigate (
                HomeFragmentDirections.actionHomeFragmentToExerciseFragment()
            )
        }
    }

    private fun hideMenu() {
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view.visibility = View.GONE
    }
}