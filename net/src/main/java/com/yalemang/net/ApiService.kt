package com.yalemang.net

import com.yalemang.net.bean.CommonBean
import com.yalemang.net.bean.DataList
import com.yalemang.net.bean.HomeBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/article/list/{page}/json")
    suspend fun homeArticle(@Path("page") page: Int): CommonBean<HomeBean>
}