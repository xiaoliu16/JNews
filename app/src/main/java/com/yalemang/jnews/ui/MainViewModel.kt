package com.yalemang.jnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yalemang.baselib.base.BaseViewModel
import com.yalemang.net.bean.HomeBean

class MainViewModel : BaseViewModel() {

    private val _homeBean = MutableLiveData<HomeBean>()
    val homeBean: LiveData<HomeBean> = _homeBean

    fun fetchData(page:Int) {
        requestNet(
            onRequest = {
                // 网络请求方法
                apiService.homeArticle(0)
            },
            onSuccess = {
                // 处理请求成功的数据
            },
            onError = {
                // 处理请求错误
            },
            onStart = {
                // 请求开始时的处理
            },
            onEnd = {
                // 请求结束时的处理
            }
        )
    }
}