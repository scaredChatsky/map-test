package com.example.maptest.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.maptest.databinding.FragmentMapBinding
import com.example.maptest.domain.model.Pin
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapFragment : Fragment() {

    private val mapViewModel: MapViewModel by viewModels()
    private var binding: FragmentMapBinding? = null

    @Inject lateinit var servicePinHelper: ServicePinHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener(FILTER_REQUEST_CODE) { requestKey, _ ->
            if (requestKey != FILTER_REQUEST_CODE) return@setFragmentResultListener
            mapViewModel.refreshPins()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            mapview.map.move(
                CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 0f),
                null
            )

            mapViewModel.pins.observe(viewLifecycleOwner) { pins -> drawPins(mapview, pins) }

            fabFilter.setOnClickListener { mapViewModel.onFilterClick() }
        }
    }

    private fun drawPins(mapview: MapView, pins: List<Pin>) {
        val mapObjects = mapview.map.mapObjects.addCollection()

        pins.forEach { pin ->
            mapObjects.addPlacemark(Point(pin.coordinates.lat, pin.coordinates.lng)).apply {
                setIcon(ImageProvider.fromBitmap(servicePinHelper.create(pin.serviceName)))
            }
        }
    }

    companion object {

        const val FILTER_REQUEST_CODE = "FILTER_REQUEST_CODE"
    }
}