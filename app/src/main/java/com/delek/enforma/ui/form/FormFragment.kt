package com.delek.enforma.ui.form

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.delek.enforma.R
import com.delek.enforma.databinding.FragmentFormBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class FormFragment : Fragment() {

    val args by navArgs<FormFragmentArgs>()
    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        hideMenu()
        setUI()
    }

    private fun setUI() {
        var startTime: LocalDateTime? = null

        binding.tvTitle.text = args.type
        when (args.type) {
            "Footing" -> binding.ivExercise.setImageResource(R.drawable.icon_footing)
            "Gym" -> binding.ivExercise.setImageResource(R.drawable.icon_gym)
            "Weight" -> binding.ivExercise.setImageResource(R.drawable.icon_weight)
            "Bicycle" -> binding.ivExercise.setImageResource(R.drawable.icon_bicycle)
        }
        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.btStart.setOnClickListener {
            startTime = LocalDateTime.now()
            val hora = startTime.format(DateTimeFormatter.ofPattern("HH:mm"))
            binding.btStart.backgroundTintList = requireContext().getColorStateList(R.color.primary)
            binding.btStart.setTextColor(Color.BLACK)
            binding.btStart.text = hora.toString()
            binding.btStart.textSize = 36F
            binding.btEnd.visibility = View.VISIBLE
        }
        binding.btEnd.setOnClickListener {
            val endTime = LocalDateTime.now()
            val hora = endTime.format(DateTimeFormatter.ofPattern("HH:mm"))
            binding.btEnd.backgroundTintList = requireContext().getColorStateList(R.color.primary)
            binding.btEnd.setTextColor(Color.BLACK)
            binding.btEnd.text = hora.toString()
            binding.btEnd.textSize = 36F
            startTime?.let { start ->
                val duration = Duration.between(start, endTime)
                val minutes = duration.toMinutes()
                binding.tvTotal.text =
                    getString(R.string.message_duration, args.type, minutes)
            }
        }
    }

    private fun hideMenu() {
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view.visibility = View.GONE
    }

}