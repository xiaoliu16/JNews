package com.yalemang.jnews.ui

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yalemang.baselib.base.BaseVmActivity
import com.yalemang.jnews.R
import com.yalemang.jnews.databinding.ActivityMainBinding
import com.yalemang.jnews.ui.main.adapter.MainPageAdapter

class MainActivity : BaseVmActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()

    companion object {
        const val PAGE_HOME = 0
        const val PAGE_VIDEO = 1
        const val PAGE_MINE = 2
    }

    override fun initView() {
        binding.run {
            viewPager2.adapter = MainPageAdapter(this@MainActivity)
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                when (position) {
                    PAGE_HOME -> {
                        tab.id = 1
                        tab.text = "首页"
                        tab.setIcon(R.drawable.nav_home_green)
                    }

                    PAGE_VIDEO -> {
                        tab.id = 2
                        tab.text = "视频"
                        tab.setIcon(R.drawable.nav_video)
                    }

                    PAGE_MINE -> {
                        tab.id = 3
                        tab.text = "我的"
                        tab.setIcon(R.drawable.nav_mine)
                    }
                }
            }.attach()
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val tabIconColor =
                        ContextCompat.getColor(this@MainActivity, R.color.light_green)
                    if (tab != null) {
                        tab.icon!!.colorFilter =
                            PorterDuffColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                    }
                }

                @SuppressLint("UseCompatLoadingForDrawables")
                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    if (tab != null) {
                        tab.icon = getDrawable(
                            when (tab.id) {
                                PAGE_HOME -> R.drawable.nav_home
                                PAGE_VIDEO -> R.drawable.nav_video
                                else -> R.drawable.nav_mine
                            }
                        )
                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    val tabIconColor =
                        ContextCompat.getColor(this@MainActivity, R.color.light_green)
                    if (tab != null) {
                        tab.icon!!.colorFilter =
                            PorterDuffColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                    }
                }
            })
            tabLayout.apply {
                selectTab(getTabAt(selectedTabPosition))
            }
        }
    }

    override fun initData() {

    }
}