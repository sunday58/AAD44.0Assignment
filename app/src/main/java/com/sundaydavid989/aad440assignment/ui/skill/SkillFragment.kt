package com.sundaydavid989.aad440assignment.ui.skill

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sundaydavid989.aad440assignment.R
import com.sundaydavid989.aad440assignment.ui.base.ScopedFragment
import kotlinx.coroutines.launch

class SkillFragment : ScopedFragment() {


    private lateinit var viewModel: SkillViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skill_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SkillViewModel::class.java)


    }


}