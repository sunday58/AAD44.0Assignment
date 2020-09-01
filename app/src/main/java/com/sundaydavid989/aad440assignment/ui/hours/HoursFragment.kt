package com.sundaydavid989.aad440assignment.ui.hours

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sundaydavid989.aad440assignment.R

class HoursFragment : Fragment() {

    companion object {
        fun newInstance() = HoursFragment()
    }

    private lateinit var viewModel: HoursViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hours_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HoursViewModel::class.java)
        // TODO: Use the ViewModel
    }

}