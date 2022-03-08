package com.example.maptest.domain

import com.example.maptest.domain.model.Pin
import javax.inject.Inject

class GetPinsUseCase @Inject constructor(
    private val pinsRepository: PinsRepository
) {

    operator fun invoke(): List<Pin> = pinsRepository.getPins()
}