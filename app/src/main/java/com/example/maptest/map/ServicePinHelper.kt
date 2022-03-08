package com.example.maptest.map

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.maptest.dpToPx

object ServicePinHelper {

    fun create(serviceName: String): Bitmap {
        val width = 24.dpToPx
        val height = 24.dpToPx
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        drawText(serviceName, Canvas(bitmap), width, height)
        return bitmap
    }

    private fun drawText(text: String, canvas: Canvas, width: Int, height: Int) {
        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        val centerX = width / 2f
        val centerY = height / 2f
        canvas.drawCircle(centerX, centerY, 12.dpToPx.toFloat(), paint)

        val textSize = 14.dpToPx.toFloat()
        paint.color = Color.WHITE
        paint.isAntiAlias = true
        paint.textSize = textSize
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(text, centerX, centerY + textSize / 2, paint)
    }
}