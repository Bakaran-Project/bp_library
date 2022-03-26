package com.bp.library.ui.pages.dashboard

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.ui.component.BpBottomNavigation
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 26/03/22 - 20.21
 * site https://trian.app
 */
@Composable
fun BaseDashboard(
    modifier: Modifier = Modifier,
    router: NavHostController,
    topAppbar:@Composable ()->Unit={},
    body:@Composable ()->Unit={}
) {
    Scaffold(
        topBar = {
            topAppbar.invoke()
        },
        bottomBar = {
            BpBottomNavigation(router = router)
        }
    ) {
        body.invoke()
    }
}

@Preview
@Composable
fun PreviewBaseDashboard() {
    BpLibraryTheme {
        BaseDashboard(router = rememberNavController())
    }
}