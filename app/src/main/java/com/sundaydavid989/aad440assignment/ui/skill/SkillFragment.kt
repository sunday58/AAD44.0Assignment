package com.sundaydavid989.aad440assignment.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sundaydavid989.aad440assignment.databinding.SkillFragmentBinding
import com.sundaydavid989.aad440assignment.ui.adapter.SkillIQAdapter
import com.sundaydavid989.aad440assignment.ui.base.ScopedFragment
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class SkillFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: SkillViewModelFactory by instance()
    private lateinit var viewModel: SkillViewModel
    private var _binding: SkillFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var adapter:SkillIQAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SkillFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SkillViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = launch {
        binding!!.skillRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val skill = viewModel.skill.await()
        skill.observe(viewLifecycleOwner, Observer {skillList ->
            if (skillList == null) return@Observer
            adapter = SkillIQAdapter(requireContext(), skillList)
            binding!!.skillRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}