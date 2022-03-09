package com.example.maptest.domain

import com.example.maptest.domain.model.Pin

interface PinsRepository {

    fun getPins(): List<Pin>
}