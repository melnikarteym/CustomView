package com.example.customview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children

class FlexBoxLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desireWidth = MeasureSpec.getSize(widthMeasureSpec)
        var currentHeight = 0
        var currentRowWidth = 0
        var maxHeightInRow = 0
        children.forEach { child ->
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            currentRowWidth += child.measuredWidth
            if (currentRowWidth > desireWidth) {
                currentHeight += maxHeightInRow
                currentRowWidth = child.measuredWidth
                maxHeightInRow = child.measuredHeight
            } else {
                maxHeightInRow = maxHeightInRow.coerceAtLeast(child.measuredHeight)
            }
        }
        if (maxHeightInRow != 0) currentHeight += maxHeightInRow
        setMeasuredDimension(desireWidth, resolveSize(currentHeight, heightMeasureSpec))
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        /*var currentLeft = l
        var currentTop = t
        var maxHeightInRaw = 0
        children.forEach { child ->
            var currentRight = currentLeft + child.measuredWidth
            if (currentRight > measuredWidth) {
                currentLeft = l
                currentTop += maxHeightInRaw
                maxHeightInRaw = child.measuredHeight
                currentRight = measuredWidth
            } else {
                maxHeightInRaw = maxHeightInRaw.coerceAtLeast(child.measuredHeight)
            }
            child.layout(currentLeft, currentTop, currentRight, currentTop + maxHeightInRaw)
            currentLeft += child.measuredWidth
        }*/
    }
}
