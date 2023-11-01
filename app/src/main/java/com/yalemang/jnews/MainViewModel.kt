package com.yalemang.jnews

import com.yalemang.baselib.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    fun fetchData() {
        requestNet(
            onRequest = {
                // 网络请求方法
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