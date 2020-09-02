package com.sundaydavid989.aad440assignment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sundaydavid989.aad440assignment.databinding.ActivityMainBinding
import com.sundaydavid989.aad440assignment.ui.adapter.ViewPagerAdapter
import com.sundaydavid989.aad440assignment.ui.submit.SubmitActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = adapter
        binding.pagerHeader.setViewPager(binding.viewPager)

        binding.submitButton.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
        setContentView(view)
    }
}