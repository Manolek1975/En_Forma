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
import com.delek.enforma.data.entity.ResumeEntity
import com.delek.enforma.databinding.FragmentFormBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Field
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
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

    fun initUI(){
        hideMenu()
        checkActive()
        initListeners()
    }

    private fun checkActive() {
        viewModel.getLast()
        viewModel.resume.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.btStart.visibility = View.VISIBLE
                binding.btEnd.visibility = View.GONE
                showUI(args.type)
            } else if(!it.active){
                binding.btStart.visibility = View.VISIBLE
            binding.btEnd.visibility = View.GONE
            showUI(args.type)
        } else {
                binding.btStart.visibility = View.GONE
                binding.btEnd.visibility = View.VISIBLE
                binding.textClock.visibility = View.VISIBLE
                showUI(it.exercise)
            }
        }
    }

    fun showUI(id: Int){
        viewModel.getExerciseById(id)
        viewModel.exercise.observe(viewLifecycleOwner){ ex ->
            val id = getResId(ex.image, R.drawable::class.java)
            binding.ivExercise.setImageResource(id)
            binding.tvTitle.text = ex.name
        }
    }

    private fun initListeners() {
        binding.btStart.setOnClickListener {
            initExercise()
        }
        binding.btEnd.setOnClickListener {
            endExercise()
        }
        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    fun initExercise() {
        var resume = ResumeEntity(0, 0, "", "", "", 0, false)
        val textClock = TextClock(context)
        val startTime = LocalDateTime.now()
        val hora = startTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.tvInit.text = hora
        binding.textClock.text = textClock.text
        val date = LocalDate.now().toString()
        val time =  LocalTime.now().toString()
        viewModel.getExerciseById(args.type)
        viewModel.exercise.observe(viewLifecycleOwner){
            resume = ResumeEntity(0, it.id, date, time, "", 0, true)
        }
        viewModel.insertResume(resume)
        binding.textClock.visibility = View.VISIBLE
        binding.btEnd.visibility = View.VISIBLE
        binding.btStart.visibility = View.GONE
    }

    fun endExercise() {
        val endTime = LocalDateTime.now()
        val time = LocalTime.now().toString()
        val hora = endTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.tvEnd.text = hora
        viewModel.getLast()
        viewModel.resume.observe(viewLifecycleOwner) {
            val start = LocalTime.parse(it.startTime)
            val duration = Duration.between(start, endTime)
            val minutes = duration.toMinutes()
            viewModel.updateActive(time, minutes.toInt(), false)
            binding.textClock.visibility = View.GONE
            binding.btStart.visibility = View.GONE
            binding.btEnd.visibility = View.GONE
        }
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