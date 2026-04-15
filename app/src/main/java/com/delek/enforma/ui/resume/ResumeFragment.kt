package com.delek.enforma.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.enforma.databinding.FragmentResumeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ResumeFragment : Fragment() {

    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResumeViewModel by viewModels()
    private lateinit var adapter: ResumeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResumeBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI() {
        adapter = ResumeAdapter()
        binding.rvResume.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvResume.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.resume.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                    println(it)
                }
            }

        }
    }

}