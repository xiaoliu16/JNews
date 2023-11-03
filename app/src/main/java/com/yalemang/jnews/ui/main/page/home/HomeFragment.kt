package com.yalemang.jnews.ui.main.page.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yalemang.baselib.base.BaseVmFragment
import com.yalemang.jnews.databinding.FragmentHomeBinding
import com.yalemang.jnews.ui.main.page.home.adapter.HomeAdapter

class HomeFragment : BaseVmFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var mAdapter: HomeAdapter

    private var page = 0
    override fun initView() {
        binding.run {
            recyclerView.layoutManager = LinearLayoutManager(requireActivity())
            mAdapter = HomeAdapter()
            recyclerView.adapter = mAdapter

            //下拉刷新
            smartHome.setOnRefreshListener {
                page = 0 // 重置页数为第一页
                homeViewModel.homePageData(page)
                smartHome.finishRefresh()
            }
            //上拉加载
            smartHome.setOnLoadMoreListener {
                page++
                homeViewModel.homePageData(page)
                smartHome.finishLoadMore()
            }
        }
    }

    override fun initData() {
        homeViewModel.homePageData(page)
    }

    override fun initObserver() {
        super.initObserver()
        homeViewModel.homeBean.observe(this) {
            mAdapter.addData(it.data.datas)
        }
    }
}