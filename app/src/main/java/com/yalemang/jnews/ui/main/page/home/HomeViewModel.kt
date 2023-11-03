package com.yalemang.jnews.ui.main.page.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yalemang.baselib.base.BaseViewModel
import com.yalemang.net.bean.CommonBean
import com.yalemang.net.bean.DataList
import com.yalemang.net.bean.HomeBean

class HomeViewModel : BaseViewModel() {

    private val _homeBean = MutableLiveData<CommonBean<HomeBean>>()
    val homeBean: LiveData<CommonBean<HomeBean>> = _homeBean

    fun homePageData(page: Int) {
        requestNet(onRequest = {
            apiService.homeArticle(page)
        }, onSuccess = {
            _homeBean.value = it
        }, onError = {

        })
    }
}