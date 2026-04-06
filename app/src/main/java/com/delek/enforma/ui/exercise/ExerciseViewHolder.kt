package com.delek.enforma.ui.exercise

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.enforma.R
import com.delek.enforma.databinding.ItemExerciseBinding
import com.delek.enforma.domain.model.Exercise
import java.lang.reflect.Field

class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemExerciseBinding.bind(view)

    fun render(exercise: Exercise, onItemSelected: (Exercise) -> Unit) {
        val id = getResId(exercise.image, R.drawable::class.java)
        binding.itemImage.setImageResource(id)
        binding.itemText.text = exercise.name

        binding.itemImage.setOnClickListener {
            selectItem(binding.itemImage, goExercise = {onItemSelected(exercise)})
        }
    }

    fun selectItem (view: View, goExercise: () -> Unit){
        goExercise()
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