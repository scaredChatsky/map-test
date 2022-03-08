package com.example.maptest.domain

import javax.inject.Inject

class GetServicesUseCase @Inject constructor(
    private val pinsRepository: PinsRepository
) {

    operator fun invoke(): List<String> = pinsRepository.getServices()
}