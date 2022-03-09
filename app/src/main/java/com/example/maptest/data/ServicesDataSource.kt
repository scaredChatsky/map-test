package com.example.maptest.data

import com.example.maptest.R
import com.example.maptest.data.model.PinsDataModel
import com.example.maptest.domain.model.Service
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServicesDataSource @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val gson: Gson,
) {

    private var cachedData: PinsDataModel? = null
    private var disabledServices: MutableSet<Service> = mutableSetOf()

    fun disableService(service: Service) {
        disabledServices.add(service)
    }

    fun enableService(service: Service) {
        disabledServices = disabledServices.filter { it.name != service.name }.toMutableSet()
    }

    fun getDisabledServices(): Set<Service> = disabledServices

    fun getServicesData(): PinsDataModel =
        cachedData ?: gson.fromJson(resourcesProvider.getRawAsString(R.raw.pins), PinsDataModel::class.java)
            .also {
                cachedData = it
            }
}