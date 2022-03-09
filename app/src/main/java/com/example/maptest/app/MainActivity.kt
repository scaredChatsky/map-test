package com.example.maptest.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maptest.R
import com.example.maptest.navigation.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.container)

    @Inject lateinit var cicerone: Cicerone<Router>
    @Inject lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(getString(R.string.yandex_map_key))
        MapKitFactory.initialize(this)

        setContentView(R.layout.activity_main)

        router.newRootScreen(Screens.MapScreen)
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }
}