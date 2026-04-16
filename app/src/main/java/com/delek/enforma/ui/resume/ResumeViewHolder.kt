package com.delek.enforma.ui.resume

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.enforma.R
import com.delek.enforma.databinding.ItemResumeBinding
import com.delek.enforma.domain.model.Resume
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ResumeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemResumeBinding.bind(view)

    fun render(resume: Resume) {
        binding.itemName.text = resume.exercise.toString()
        val date = LocalDate.parse(resume.date)
        val dateExercise = date.format(DateTimeFormatter.ofPattern("dd-MM-yy"))
        binding.itemDate.text = dateExercise
        val startTime = LocalTime.parse(resume.startTime)
        val init = startTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.itemStart.text = init
        val endTime = LocalTime.parse(resume.endTime)
        val end = endTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.itemEnd.text = end
        binding.itemTotal.text = itemView.context.getString(R.string.total, resume.duration)
    }

}