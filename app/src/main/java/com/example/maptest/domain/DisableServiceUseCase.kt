package com.example.maptest.domain

import com.example.maptest.domain.model.Service
import javax.inject.Inject

class DisableServiceUseCase @Inject constructor(
    private val servicesRepository: ServicesRepository
) {

    operator fun invoke(service: Service) {
        servicesRepository.disableService(service)
    }
}