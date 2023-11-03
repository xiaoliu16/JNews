package com.yalemang.net.bean

data class CommonBean<T>(
    val data: T, val errorCode: Int, val errorMsg: String
)