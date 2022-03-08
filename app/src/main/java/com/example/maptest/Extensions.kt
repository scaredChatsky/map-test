package com.example.maptest

import android.content.res.Resources

val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()