package com.sundaydavid989.aad440assignment.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sundaydavid989.aad440assignment.ui.hours.HoursFragment
import com.sundaydavid989.aad440assignment.ui.skill.SkillFragment

class ViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm){

    private val COUNT = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = HoursFragment()
            1 -> fragment = SkillFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Learning Leaders"
            1 -> return "Skill IQ Leaders"
        }
        return null
    }

}