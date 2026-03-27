package com.delek.enforma.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.delek.enforma.databinding.FragmentResumeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResumeFragment : Fragment() {

    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResumeBinding.inflate(inflater, container, false)
        return binding.root
    }

}