package com.example.customview

import android.content.Context

fun Int.dpToPx(ctx: Context): Int = (this * ctx.resources.displayMetrics.density).toInt()