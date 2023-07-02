package com.bp.library.ui.pages.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.trian.mvi.Navigation
import app.trian.mvi.ui.UIWrapper
import app.trian.mvi.ui.internal.UIContract
import app.trian.mvi.ui.internal.rememberUIController
import com.bp.library.ui.component.BpBottomNavigation
import com.bp.library.ui.pages.dashboard.component.ScreenType
import com.bp.library.ui.pages.dashboard.screen.PageBookmark
import com.bp.library.ui.pages.dashboard.screen.PageHome
import com.bp.library.ui.pages.dashboard.screen.PageProfile
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 26/03/22 - 20.21
 * site https://trian.app
 */
object Dashboard{
    const val routeName="Dahsbord"
}
@Navigation(
    route=Dashboard.routeName,
    viewModel=DashboardViewModel::class
)
@Composable
fun DashboardScreen(
    uiContract: UIContract<DashboardState, DashboardIntent, DashboardAction>
) = UIWrapper(uiContract = uiContract) {
    Scaffold(
        bottomBar = {
            BpBottomNavigation(
                currentScreenType = state.screenType,
                onClick = {
                    commit { copy(screenType = it) }
                },
                onFabClick = {

                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            when (state.screenType) {
                ScreenType.HOME -> PageHome(router = navigator.navHost)
                ScreenType.PROFILE -> PageProfile(router = navigator.navHost)
                ScreenType.STATISTIC -> PageProfile(router = navigator.navHost)
                ScreenType.BOOKMARK -> PageBookmark(router = navigator.navHost)
            }
        }
    }
}

@Preview
@Composable
fun PreviewBaseDashboard() {
    BpLibraryTheme {
        DashboardScreen(
            uiContract = UIContract(
                controller = rememberUIController(),
                state = DashboardState()
            )
        )
    }
}