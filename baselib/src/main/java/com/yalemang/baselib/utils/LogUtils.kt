package com.yalemang.baselib.utils

import android.util.Log
import com.blankj.utilcode.BuildConfig

object LogUtils {

    private const val TAG = "LogUtils"
    private var DEBUG = BuildConfig.DEBUG

    /**
     * 设置日志是否可打印
     */
    fun setDebug(debug: Boolean) {
        DEBUG = debug
    }

    fun d(message: String) {
        if (DEBUG) {
            Log.d(TAG, message)
        }
    }

    fun e(message: String) {
        if (DEBUG) {
            Log.e(TAG, message)
        }
    }

    fun i(message: String) {
        if (DEBUG) {
            Log.e(TAG, message)
        }
    }

    fun v(message: String) {
        if (DEBUG) {
            Log.e(TAG, message)
        }
    }

    fun w(message: String) {
        if (DEBUG) {
            Log.e(TAG, message)
        }
    }
}