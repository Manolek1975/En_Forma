package com.delek.enforma.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.enforma.R
import com.delek.enforma.databinding.FragmentFormBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Field
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class FormFragment : Fragment() {

    val args by navArgs<FormFragmentArgs>()
    private val viewModel: FormViewModel by viewModels()
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
        viewModel.getExerciseById(args.type)
        viewModel.exercise.observe(viewLifecycleOwner){
            val id = getResId(it.image, R.drawable::class.java)
            binding.ivExercise.setImageResource(id)
            binding.tvTitle.text = it.name
        }
        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.btStart.setOnClickListener {
            initExercise()
        }
        binding.btEnd.setOnClickListener {
            endExercise()
        }
    }

    fun initExercise() {
        val textClock = TextClock(context)
        val startTime = LocalDateTime.now()
        val hora = startTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.tvInit.text = hora
        binding.textClock.visibility = View.VISIBLE
        binding.textClock.text = textClock.text
        binding.btStart.visibility = View.GONE
        binding.btEnd.visibility = View.VISIBLE
        //TODO Guardar en la base de datos
    }

    fun endExercise() {
        val endTime = LocalDateTime.now()
        val hora = endTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.tvEnd.text = hora
        binding.textClock.visibility = View.GONE
        binding.btStart.visibility = View.GONE
        binding.btEnd.visibility = View.GONE
        //TODO Guardar en la base de datos
        //TODO Calcular Total
/*        startTime?.let { start ->
            val duration = Duration.between(start, endTime)
            val minutes = duration.toMinutes()
            binding.tvTotal.text =
                getString(R.string.message_duration, minutes)
        }*/
    }


    private fun hideMenu() {
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view.visibility = View.GONE
    }

    fun getResId(resName: String?, c: Class<*>): Int {
        try {
            val idField: Field = c.getDeclaredField(resName!!)
            return idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }
    }

}