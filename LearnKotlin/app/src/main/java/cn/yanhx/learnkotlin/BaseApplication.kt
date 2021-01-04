package cn.yanhx.learnkotlin

import android.app.Application
import android.content.Context

class BaseApplication : Application() {

    companion object {
        private lateinit var context:Context
        fun currentApplication():Context {
            return context
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base

    }
}
