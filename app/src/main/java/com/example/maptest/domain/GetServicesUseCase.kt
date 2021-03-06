package com.example.maptest.domain

import com.example.maptest.domain.model.Service
import javax.inject.Inject

class GetServicesUseCase @Inject constructor(
    private val servicesRepository: ServicesRepository
) {

    operator fun invoke(): List<Service> = servicesRepository.getServices()
}