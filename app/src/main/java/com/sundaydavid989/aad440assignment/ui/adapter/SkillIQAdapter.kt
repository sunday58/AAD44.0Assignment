package com.sundaydavid989.aad440assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sundaydavid989.aad440assignment.data.entity.SkillItem
import com.sundaydavid989.aad440assignment.databinding.SkillItemListBinding
import com.sundaydavid989.aad440assignment.internal.glide.GlideApp

class SkillIQAdapter(private val context: Context, private val skillList: List<SkillItem>)
    :RecyclerView.Adapter<SkillIQAdapter.SkillViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val binding = SkillItemListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SkillViewHolder(binding)
    }

    override fun getItemCount() = skillList.size

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        with(holder){
            with(skillList[position]) {
                binding.skillLeaderName.text = name
                binding.SkillLeaderScore.text = score.toString()
                GlideApp.with(context)
                    .load(badgeUrl)
                    .into(binding.skillLeaderImage)
            }
        }
    }

    inner class SkillViewHolder(val binding: SkillItemListBinding)
        :RecyclerView.ViewHolder(binding.root)

}