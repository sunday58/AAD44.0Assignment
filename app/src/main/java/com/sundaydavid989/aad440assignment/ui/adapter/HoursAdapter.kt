package com.sundaydavid989.aad440assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sundaydavid989.aad440assignment.data.entity.Hours
import com.sundaydavid989.aad440assignment.databinding.HoursListItemsBinding

class HoursAdapter(private val context: Context, private val hoursList: Hours)
    :RecyclerView.Adapter<HoursAdapter.HoursViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val binding = HoursListItemsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HoursViewHolder(binding)
    }

    override fun getItemCount() = hoursList.size

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        with(holder){
            with(hoursList[position]) {
                binding.topLearnerName.text = name
                binding.topLearnerTime.text = hours.toString()
            }
        }
    }

    inner class HoursViewHolder(val binding: HoursListItemsBinding)
        :RecyclerView.ViewHolder(binding.root)

}