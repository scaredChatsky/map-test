package com.example.maptest.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maptest.domain.DisableServiceUseCase
import com.example.maptest.domain.EnableServiceUseCase
import com.example.maptest.domain.GetServicesUseCase
import com.example.maptest.domain.model.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    private val getServicesUseCase: GetServicesUseCase,
    private val enabledServicesUseCase: EnableServiceUseCase,
    private val disableServiceUseCase: DisableServiceUseCase
) : ViewModel() {

    private val _services: MutableLiveData<List<Service>> = MutableLiveData()
    val services: LiveData<List<Service>> = _services

    private val _doneEvent: MutableLiveData<Boolean> = MutableLiveData()
    val doneEvent: LiveData<Boolean> = _doneEvent

    init {
        loadServices()
    }

    fun onServiceClick(service: Service) {
        if (service.enabled) {
            disableServiceUseCase(service)
        } else {
            enabledServicesUseCase(service)
        }
    }

    fun onDoneClick() {
        _doneEvent.value = true
    }

    private fun loadServices() {
        _services.value = getServicesUseCase()
    }
}