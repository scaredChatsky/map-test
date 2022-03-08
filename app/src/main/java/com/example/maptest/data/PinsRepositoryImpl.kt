package com.example.maptest.data

import com.example.maptest.R
import com.example.maptest.data.model.Pin
import com.example.maptest.data.model.PinsData
import com.example.maptest.domain.PinsRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PinsRepositoryImpl @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val gson: Gson
) : PinsRepository {

    private var cachedData: PinsData? = null

    override fun getPins(): List<Pin> = getAllData().pins

    override fun getServices(): List<String> = getAllData().services

    private fun getAllData(): PinsData =
        cachedData ?: gson.fromJson(resourcesProvider.getRawAsString(R.raw.pins), PinsData::class.java)
            .also {
                cachedData = it
            }
}