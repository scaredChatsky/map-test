package com.example.maptest.domain

import com.example.maptest.data.model.Pin

interface PinsRepository {

    fun getPins(): List<Pin>
    fun getServices(): List<String>
}