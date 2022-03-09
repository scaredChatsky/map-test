package com.example.maptest.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.maptest.databinding.FragmentFiltersBinding
import com.example.maptest.map.MapFragment
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FiltersFragment : Fragment() {

    private var binding: FragmentFiltersBinding? = null
    private val filtersViewModel: FiltersViewModel by viewModels()

    @Inject lateinit var router: Router

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            filtersViewModel.services.observe(viewLifecycleOwner) { services ->
                val adapter = ServicesAdapter(filtersViewModel::onServiceClick)
                adapter.setData(services)
                rvServices.adapter = adapter
            }

            fabDone.setOnClickListener {
                filtersViewModel.onDoneClick()
            }

            filtersViewModel.doneEvent.observe(viewLifecycleOwner) {
                setFragmentResult(MapFragment.FILTER_REQUEST_CODE, bundleOf())
                router.exit()
            }
        }
    }
}