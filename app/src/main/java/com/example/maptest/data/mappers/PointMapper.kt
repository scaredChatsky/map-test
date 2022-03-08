package com.example.maptest.data.mappers

import com.example.maptest.data.model.PointModel
import com.example.maptest.domain.model.Point
import javax.inject.Inject

class PointMapper @Inject constructor() {

    fun map(from: PointModel): Point = Point(from.lat, from.lng)
}