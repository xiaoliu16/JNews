package com.yalemang.jnews

import android.app.Application
import android.content.Context
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.yalemang.baselib.utils.LogUtils

class App : Application() {
    companion object {
        init {
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context: Context?, layout: RefreshLayout ->
                layout.setPrimaryColorsId(R.color.white, R.color.black) //全局设置主题颜色
                ClassicsHeader(context)
            }
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter(context).setDrawableSize(20f) //设置下拉箭头的大小（dp单位）
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        LogUtils.setDebug(false)
    }
}