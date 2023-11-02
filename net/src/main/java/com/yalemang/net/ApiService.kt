package com.yalemang.net

import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/article/list/0/json")
    suspend fun homeArticle(): CommonBean<HomeBean>
}