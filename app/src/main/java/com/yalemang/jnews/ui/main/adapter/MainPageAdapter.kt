package com.yalemang.jnews.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yalemang.jnews.ui.main.page.home.HomeFragment
import com.yalemang.jnews.ui.main.MineFragment
import com.yalemang.jnews.ui.main.VideoFragment

class MainPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments =
        listOf(HomeFragment(), VideoFragment(), MineFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}