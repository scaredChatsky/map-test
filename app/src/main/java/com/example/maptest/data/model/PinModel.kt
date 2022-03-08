package com.example.maptest.data.model

import com.google.gson.annotations.SerializedName

data class PinModel(
    @SerializedName("id") val id: Long,
    @SerializedName("service") val serviceName: String,
    @SerializedName("coordinates") val coordinates: PointModel
)