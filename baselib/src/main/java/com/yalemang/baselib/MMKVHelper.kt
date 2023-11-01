package com.yalemang.baselib
import com.tencent.mmkv.MMKV

class MMKVHelper(private val mmkv: MMKV) {

    constructor(name: String) : this(MMKV.mmkvWithID(name))

    fun isContains(key: String): Boolean {
        return mmkv.contains(key)
    }

    fun save(key: String, value: Any) {
        when (value) {
            is String -> mmkv.encode(key, value)
            is Int -> mmkv.encode(key, value)
            is Boolean -> mmkv.encode(key, value)
            is Float -> mmkv.encode(key, value)
            is Long -> mmkv.encode(key, value)
            else -> mmkv.encode(key, value.toString())
        }
    }

    fun getValue(key: String, defaultValue: Any): Any? {
        return when (defaultValue) {
            is String -> mmkv.decodeString(key, defaultValue)
            is Int -> mmkv.decodeInt(key, defaultValue)
            is Boolean -> mmkv.decodeBool(key, defaultValue)
            is Float -> mmkv.decodeFloat(key, defaultValue)
            is Long -> mmkv.decodeLong(key, defaultValue)
            else -> mmkv.decodeString(key, defaultValue.toString())
        }
    }
}