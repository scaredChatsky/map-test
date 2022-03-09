package com.example.maptest.data

import com.example.maptest.domain.PinsRepository
import com.example.maptest.domain.model.Pin
import javax.inject.Inject

class PinsRepositoryImpl @Inject constructor(
    private val servicesDataSource: ServicesDataSource,
    private val pinMapper: PinMapper
) : PinsRepository {

    override fun getPins(): List<Pin> = servicesDataSource.getServicesData().pins.map(pinMapper::map)
}