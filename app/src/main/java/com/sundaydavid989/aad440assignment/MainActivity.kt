package com.sundaydavid989.aad440assignment

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sundaydavid989.aad440assignment.databinding.ActivityMainBinding
import com.sundaydavid989.aad440assignment.ui.adapter.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.pagerHeader.setTextColor(Color.WHITE)
        binding.pagerHeader.setTabIndicatorColorResource(R.color.white)
        binding.viewPager.adapter = adapter
        setContentView(view)
    }
}