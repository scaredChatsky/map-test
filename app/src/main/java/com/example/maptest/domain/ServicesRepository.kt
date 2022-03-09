package com.example.maptest.domain

import com.example.maptest.domain.model.Service

interface ServicesRepository {

    fun getServices(): List<Service>
    fun disableService(service: Service)
    fun enableService(service: Service)
    fun getDisabledServices(): Set<Service>
}