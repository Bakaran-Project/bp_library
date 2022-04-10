package com.bp.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bp.library.ui.pages.PageSplashScreen
import com.bp.library.ui.pages.auth.PageLogin
import com.bp.library.ui.pages.auth.PageRegister
import com.bp.library.ui.pages.dashboard.PageBookmark
import com.bp.library.ui.pages.dashboard.PageHome
import com.bp.library.ui.pages.dashboard.PageProfile
import com.bp.library.ui.pages.dashboard.PageStatistic
import com.bp.library.ui.pages.onboard.PageOnboard
import com.bp.library.ui.theme.BpLibraryTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

/**
 * author Trian Damai
 * created_at 21/03/22 - 13.45
 * site https://trian.app
 */
@ExperimentalPagerApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BpLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val router = rememberAnimatedNavController()
                    val systemUITheme = rememberSystemUiController()

                    AnimatedNavHost(
                        navController = router,
                        startDestination = Routes.SPLASH
                    ){
                        composable(Routes.SPLASH){
                            systemUITheme.setSystemBarsColor(
                                    color = MaterialTheme.colors.surface,
                                    darkIcons = true,
                            )
                            PageSplashScreen(router = router)
                        }
                        composable(Routes.ONBOARD){
                            systemUITheme.setSystemBarsColor(
                                color = MaterialTheme.colors.primary,
                                darkIcons = false,
                            )
                            PageOnboard(router = router)
                        }
                        composable(Routes.LOGIN){
                            systemUITheme.setSystemBarsColor(
                                color = MaterialTheme.colors.surface,
                                darkIcons = true,
                            )
                            PageLogin(router = router)
                        }
                        composable(Routes.REGISTER){
                            systemUITheme.setSystemBarsColor(
                                color = MaterialTheme.colors.surface,
                                darkIcons = true,
                            )
                            PageRegister(router = router)
                        }
                        navigation(route = Routes.DASHBOARD, startDestination = Routes.Dashboard.HOME){
                            composable(Routes.Dashboard.HOME){
                                PageHome(router = router)
                            }
                            composable(Routes.Dashboard.STATISTIC){
                                PageStatistic(router = router)
                            }
                            composable(Routes.Dashboard.BOOKMARK){
                                PageBookmark(router = router)
                            }
                            composable(Routes.Dashboard.PROFILE){
                                PageProfile(router = router)
                            }
                        }
                    }

                }
            }
        }
    }
}

