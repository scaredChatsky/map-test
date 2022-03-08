package com.example.maptest.data.model

import com.google.gson.annotations.SerializedName

data class PinsDataModel(
    @SerializedName("services") val services: List<String>,
    @SerializedName("pins") val pins: List<PinModel>
)