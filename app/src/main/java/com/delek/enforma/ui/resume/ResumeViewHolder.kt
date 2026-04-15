package com.delek.enforma.ui.resume

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.enforma.databinding.ItemResumeBinding
import com.delek.enforma.domain.model.Resume

class ResumeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemResumeBinding.bind(view)

    fun render(resume: Resume){
        binding.itemName.text = resume.exercise.toString()
        binding.itemStart.text = resume.startTime
        binding.itemEnd.text = resume.endTime
        binding.itemTotal.text = resume.duration.toString()
    }

}