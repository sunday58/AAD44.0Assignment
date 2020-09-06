package com.sundaydavid989.aad440assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sundaydavid989.aad440assignment.data.entity.HoursItem
import com.sundaydavid989.aad440assignment.databinding.HoursListItemsBinding
import com.sundaydavid989.aad440assignment.internal.glide.GlideApp

class HoursAdapter(private val context: Context, private val hoursList: List<HoursItem>)
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
                val hours = hours.toString() + "learning hours, " + country
                binding.topLearnerTime.text = hours
                GlideApp.with(context)
                    .load(badgeUrl)
                    .into(binding.topLearnerImage)

                holder.itemView.setOnClickListener {
                    Toast.makeText(context, hours.toString(),
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    inner class HoursViewHolder(val binding: HoursListItemsBinding)
        :RecyclerView.ViewHolder(binding.root)

}