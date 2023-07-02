package com.bp.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import app.trian.mvi.appComponent
import app.trian.mvi.ui.internal.UIController
import app.trian.mvi.ui.internal.listener.BaseEventListener
import app.trian.mvi.ui.internal.listener.EventListener
import app.trian.mvi.ui.internal.rememberUIController
import com.bp.library.ui.pages.splash.Splash
import com.bp.library.ui.theme.BpLibraryTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * author Trian Damai
 * created_at 21/03/22 - 13.45
 * site https://trian.app
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var uiController: UIController
    private lateinit var event: BaseEventListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            event = EventListener()
            uiController = rememberUIController(event)

            BpLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = uiController.navigator.navHost,
                        startDestination = Splash.routeName
                    ) {
                        //systemUITheme.setSystemBarsColor(
                        //      color = MaterialTheme.colors.surface,
                        //      darkIcons = true,
                        // )
                        appComponent(uiController,event)
                    }
                }
            }
        }
    }
}

