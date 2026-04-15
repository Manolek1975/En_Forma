package com.delek.enforma.ui.resume

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.enforma.R
import com.delek.enforma.domain.model.Resume

class ResumeAdapter(private var resumeList: List<Resume> = emptyList()): RecyclerView.Adapter<ResumeViewHolder>()  {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Resume>){
        resumeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeViewHolder {
        return ResumeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_resume, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResumeViewHolder, position: Int) {
        holder.render(resumeList[position])
    }

    override fun getItemCount(): Int = resumeList.count()
}