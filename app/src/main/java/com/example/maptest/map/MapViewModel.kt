package com.example.maptest.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maptest.domain.GetPinsUseCase
import com.example.maptest.domain.model.Pin
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val getPinsUseCase: GetPinsUseCase
) : ViewModel() {

    private val _pins: MutableLiveData<List<Pin>> = MutableLiveData()
    val pins: LiveData<List<Pin>> = _pins

    init {
        _pins.value = getPinsUseCase()
    }
}