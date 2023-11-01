package com.yalemang.jnews

import android.app.Application
import com.yalemang.baselib.utils.LogUtils

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        LogUtils.setDebug(false)
    }
}