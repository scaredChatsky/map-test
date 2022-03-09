package com.example.maptest.domain

import com.example.maptest.domain.model.Service
import javax.inject.Inject

class GetDisabledServicesUseCase @Inject constructor(
    private val servicesRepository: ServicesRepository
) {

    operator fun invoke(): Set<Service> = servicesRepository.getDisabledServices()
}