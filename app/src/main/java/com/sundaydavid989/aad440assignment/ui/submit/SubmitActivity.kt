package com.sundaydavid989.aad440assignment.ui.submit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sundaydavid989.aad440assignment.MainActivity
import com.sundaydavid989.aad440assignment.R
import com.sundaydavid989.aad440assignment.databinding.ActivitySubmitBinding

class SubmitActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubmitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        val view = binding.root

        goBack()
        setContentView(view)
    }

    private fun goBack(){
        binding.goBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}