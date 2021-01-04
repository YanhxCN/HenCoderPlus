package cn.yanhx.learnkotlin.utils

import android.content.Context
import cn.yanhx.learnkotlin.BaseApplication
import cn.yanhx.learnkotlin.R

object CacheUtils {
    private val context = BaseApplication.currentApplication()
    private val SP = context.getSharedPreferences(context.getString(R.string.sp), Context.MODE_PRIVATE)

    fun save(key:String?, value: String?) {
        SP.edit().putString(key,value).apply()
    }

    fun get(key: String?):String? {
        return SP.getString(key,null)
    }
}