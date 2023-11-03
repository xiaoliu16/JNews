package com.yalemang.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetManager private constructor() {

    private var retrofit: Retrofit
    var apiService: ApiService

    companion object {
        private const val BASE_URL = "https://www.wanandroid.com"
        private val INSTANCE by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetManager()
        }
        fun getInstance() = INSTANCE
    }

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        //配置网络
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient =
            OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor).build()

        retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

        apiService = retrofit.create(ApiService::class.java)
    }
}