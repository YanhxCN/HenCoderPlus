package cn.yanhx.learnkotlin.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import cn.yanhx.learnkotlin.BaseApplication

object Utils {
    private val displayMetrics = Resources.getSystem().displayMetrics

    fun Float.dp2px() : Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
        )
    }

    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication,string,duration).show()
    }
}

