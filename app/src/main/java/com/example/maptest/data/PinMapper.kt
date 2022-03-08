package com.example.maptest.data

import com.example.maptest.data.mappers.PointMapper
import com.example.maptest.data.model.PinModel
import com.example.maptest.domain.model.Pin
import javax.inject.Inject

class PinMapper @Inject constructor(
    private val pointMapper: PointMapper
) {

    fun map(from: PinModel): Pin = Pin(
        from.id,
        from.serviceName,
        pointMapper.map(from.coordinates)
    )
}