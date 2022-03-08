package com.example.maptest.data.model

import com.google.gson.annotations.SerializedName

data class PointModel(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)