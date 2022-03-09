package com.example.maptest.data

import com.example.maptest.data.mappers.ServiceMapper
import com.example.maptest.domain.ServicesRepository
import com.example.maptest.domain.model.Service
import javax.inject.Inject

class ServicesRepositoryImpl @Inject constructor(
    private val servicesDataSource: ServicesDataSource,
    private val serviceMapper: ServiceMapper
) : ServicesRepository {

    override fun getServices(): List<Service> = servicesDataSource.getServicesData().services.map { serviceName ->
        serviceMapper.map(serviceName, !servicesDataSource.getDisabledServices().any { it.name == serviceName })
    }

    override fun disableService(service: Service) {
        servicesDataSource.disableService(service)
    }

    override fun enableService(service: Service) {
        servicesDataSource.enableService(service)
    }

    override fun getDisabledServices(): Set<Service> = servicesDataSource.getDisabledServices()
}