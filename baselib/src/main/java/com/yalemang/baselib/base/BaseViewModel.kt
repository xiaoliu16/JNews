package com.yalemang.baselib.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yalemang.net.NetManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected val apiService = NetManager.getInstance().apiService
    protected fun <T> requestNet(
        onRequest: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit = {},
        onStart: () -> Unit = {},
        onEnd: () -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                onStart()
                val result = requestFlow(onRequest).single()
                onSuccess(result)
            } catch (e: Exception) {
                onError(e)
            } finally {
                onEnd()
            }
        }
    }

    private fun <T> requestFlow(
        onRequest: suspend () -> T
    ): Flow<T> = flow {
        emit(onRequest())
    }
}