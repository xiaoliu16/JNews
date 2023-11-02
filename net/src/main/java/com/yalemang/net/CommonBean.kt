package com.yalemang.net

data class CommonBean<T>(
     val data: T ,
     val errorCode: Int,
     val errorMsg: String
)