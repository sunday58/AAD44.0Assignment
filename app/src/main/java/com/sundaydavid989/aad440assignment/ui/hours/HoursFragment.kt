package com.sundaydavid989.aad440assignment.ui.hours

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sundaydavid989.aad440assignment.databinding.HoursFragmentBinding
import com.sundaydavid989.aad440assignment.ui.adapter.HoursAdapter
import com.sundaydavid989.aad440assignment.ui.base.ScopedFragment
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HoursFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: HoursViewModelFactory by instance()
    private lateinit var viewModel: HoursViewModel
    private var _binding: HoursFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var adapter: HoursAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HoursFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HoursViewModel::class.java)
       bindUI()
    }
    private fun bindUI() = launch {
        binding!!.hoursRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val hours = viewModel.hours.await()
        hours.observe(viewLifecycleOwner, Observer {hoursList ->
            Log.d("hours", hoursList.toString())
            if (hoursList == null) return@Observer
            adapter = HoursAdapter(requireContext(), hoursList)
            binding!!.hoursRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}