package com.example.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        logSpec("width", widthMeasureSpec)
        logSpec("height", widthMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d(
            ON_LAYOUT_TAG,
            "${context.resources.getResourceName(id)} onLayout -> changed=$changed, left=$left, top=$top, right=$right, bottom=$bottom"
        )
    }

    private fun logSpec(type: String, spec: Int) {
        Log.d(
            ON_MEASURE_TAG,
            "${context.resources.getResourceName(id)} $type ${MeasureSpec.toString(spec)})"
        )
    }

    private companion object {

        private const val ON_MEASURE_TAG = "CustomView#onMeasure"
        private const val ON_LAYOUT_TAG = "CustomView#onLayout"
    }
}






