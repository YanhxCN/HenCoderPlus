package cn.yanhx.learnkotlin.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import cn.yanhx.learnkotlin.R
import cn.yanhx.learnkotlin.utils.Utils
import cn.yanhx.learnkotlin.utils.Utils.dp2px
import kotlin.random.Random

class CodeView @JvmOverloads constructor(context:Context,attr:AttributeSet? = null) : AppCompatTextView(context,attr) {

    private val paint = Paint().apply {
       isAntiAlias = true
       style = Paint.Style.STROKE
       color = getContext().getColor(R.color.colorAccent)
       strokeWidth = 6f.dp2px()
    }

    private val codeList = arrayOf(
        "kotlin",
        "android",
        "java",
        "http",
        "https",
        "okhttp",
        "retrofit",
        "tcp/ip"
    )

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_DIP,18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)


        updateCode()

    }

    fun updateCode() {
        val random = Random.nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f,height.toFloat(),width.toFloat(),0f,paint)
        super.onDraw(canvas)
    }
}