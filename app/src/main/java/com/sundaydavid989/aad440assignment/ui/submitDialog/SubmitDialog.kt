package com.sundaydavid989.aad440assignment.ui.submitDialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sundaydavid989.aad440assignment.R
import com.sundaydavid989.aad440assignment.databinding.FragmentSubmitDialogBinding

class SubmitDialog : DialogFragment() {

    private var _binding: FragmentSubmitDialogBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSubmitDialogBinding.inflate(inflater, container, false)


        return binding?.root
    }

}