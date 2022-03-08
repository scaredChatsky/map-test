package com.example.maptest.data

import com.example.maptest.R
import com.example.maptest.data.mappers.PointMapper
import com.example.maptest.data.model.PinsDataModel
import com.example.maptest.domain.PinsRepository
import com.example.maptest.domain.model.Pin
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PinsRepositoryImpl @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val gson: Gson,
    private val pinMapper: PinMapper
) : PinsRepository {

    private var cachedData: PinsDataModel? = null

    override fun getPins(): List<Pin> = getAllData().pins.map(pinMapper::map)

    override fun getServices(): List<String> = getAllData().services

    private fun getAllData(): PinsDataModel =
        cachedData ?: gson.fromJson(resourcesProvider.getRawAsString(R.raw.pins), PinsDataModel::class.java)
            .also {
                cachedData = it
            }
}