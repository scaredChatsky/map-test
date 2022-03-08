package com.example.maptest.data

import android.content.Context
import androidx.annotation.RawRes
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer
import javax.inject.Inject

class ResourcesProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun getRawAsString(@RawRes resId: Int): String {
        val inputStream = context.resources.openRawResource(resId)

        val writer: Writer = StringWriter()
        inputStream.use { inputStream ->
            val buffer = CharArray(1024)
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, CHARSET_NAME))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        return writer.toString()
    }

    private companion object {

        private const val CHARSET_NAME = "UTF-8"
    }
}