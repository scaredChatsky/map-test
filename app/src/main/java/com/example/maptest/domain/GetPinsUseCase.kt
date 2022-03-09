package com.example.maptest.domain

import com.example.maptest.domain.model.Pin
import javax.inject.Inject

class GetPinsUseCase @Inject constructor(
    private val pinsRepository: PinsRepository,
    private val getDisabledServicesUseCase: GetDisabledServicesUseCase
) {

    operator fun invoke(): List<Pin> {
        val disabledServices = getDisabledServicesUseCase()
        return pinsRepository.getPins().filter { pin ->
            !disabledServices.any { service -> pin.serviceName == service.name }
        }
    }
}