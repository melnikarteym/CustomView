package com.example.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class CompoundView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ViewGroup(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.compound_view_layout, this).let(::setupView)
    }

    private fun setupView(inflatedView: View) {

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("Not yet implemented")
    }
}




