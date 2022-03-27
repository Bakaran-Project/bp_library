package com.bp.library.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.Routes
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 19/03/22 - 20.54
 * site https://trian.app
 */
@Composable
fun PageSplashScreen(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
    LaunchedEffect(key1 = Unit, block = {
        router.navigate(Routes.LOGIN){
            popUpTo(Routes.SPLASH){
                inclusive = true
            }
            launchSingleTop = true
        }
    })
}

@Preview
@Composable
fun PreviewPageSplashScreen() {
    BpLibraryTheme {
        PageSplashScreen(router = rememberNavController())
    }
}