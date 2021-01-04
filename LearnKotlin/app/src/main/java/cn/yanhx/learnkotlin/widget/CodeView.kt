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
import kotlin.random.Random

class CodeView : AppCompatTextView {

    constructor(context:Context) : this(context,null)
    constructor(context:Context,attr:AttributeSet?) : super(context,attr) {
        setTextSize(TypedValue.COMPLEX_UNIT_DIP,18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.color = getContext().getColor(R.color.colorAccent)
        paint.strokeWidth = Utils.dp2px(6f)
        updateCode()

    }

    private val paint = Paint()
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