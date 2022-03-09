package com.example.maptest.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.maptest.filter.FiltersFragment
import com.example.maptest.map.MapFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    object MapScreen : FragmentScreen {

        override fun createFragment(factory: FragmentFactory): Fragment = MapFragment()
    }

    object FiltersScreen : FragmentScreen {

        override fun createFragment(factory: FragmentFactory): Fragment = FiltersFragment()
    }
}