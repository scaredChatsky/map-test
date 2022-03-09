package com.example.maptest.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maptest.databinding.FragmentFiltersBinding

class FiltersFragment : Fragment() {

    private var binding: FragmentFiltersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding?.root
    }
}