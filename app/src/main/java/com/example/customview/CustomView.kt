package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 4F
    }

    private val path = Path().apply {
        repeat(8) { toothNumber ->
            lineTo(toothNumber * TOOTH_WIDTH + TOOTH_WIDTH / 2, TOOTH_HEIGHT)
            lineTo(toothNumber * TOOTH_WIDTH + TOOTH_WIDTH, 0F)
        }
    }

    private val badgeRect = Rect(20, 20, 200, 20)

    private companion object {


        private const val TOOTH_WIDTH = 20F
        private const val TOOTH_HEIGHT = 40F
        private const val X_CENTER = 200F
        private const val Y_CENTER = 200F
        private const val RADIUS = 100F

    }

    override fun onDraw(canvas: Canvas) {


        canvas.drawPath(path, paint)
        canvas.drawCircle(X_CENTER, Y_CENTER, RADIUS, paint)
        canvas.drawRect(badgeRect, paint)
        canvas.drawPaint(paint)
        canvas.drawText("Some text", 100F, 100F, paint)


    }
}






