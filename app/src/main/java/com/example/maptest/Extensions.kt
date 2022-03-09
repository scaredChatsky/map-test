package com.example.maptest

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View

val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun View.inflater(): LayoutInflater = LayoutInflater.from(context)