package com.example.maptest.data.mappers

import com.example.maptest.domain.model.Service
import javax.inject.Inject

class ServiceMapper @Inject constructor() {

    fun map(from: String, enabled: Boolean): Service = Service(from, enabled)
}