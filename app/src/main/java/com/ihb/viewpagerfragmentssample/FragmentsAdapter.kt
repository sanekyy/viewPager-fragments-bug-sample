package com.ihb.viewpagerfragmentssample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentsAdapter(fragmentManager: FragmentManager) : FragmentStateAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            Page1Fragment()
        } else {
            Page2Fragment()
        }
    }

    override fun getItemCount() = 2
}