package com.delek.enforma.ui.exercise

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.enforma.R
import com.delek.enforma.domain.model.Exercise

class ExerciseAdapter (
    private var exerciseList: List<Exercise> = emptyList(),
    private val onItemSelected: (Exercise) -> Unit)
    : RecyclerView.Adapter<ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.render(exerciseList[position], onItemSelected)
    }

    override fun getItemCount() = exerciseList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Exercise>){
        exerciseList = list
        notifyDataSetChanged()
    }

}