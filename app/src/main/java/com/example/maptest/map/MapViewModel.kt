package com.example.maptest.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maptest.domain.GetPinsUseCase
import com.example.maptest.domain.model.Pin
import com.example.maptest.navigation.Screens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    getPinsUseCase: GetPinsUseCase,
    private val router: Router
) : ViewModel() {

    private val _pins: MutableLiveData<List<Pin>> = MutableLiveData()
    val pins: LiveData<List<Pin>> = _pins

    init {
        _pins.value = getPinsUseCase()
    }

    fun onFilterClick() {
        router.navigateTo(Screens.FiltersScreen)
    }
}