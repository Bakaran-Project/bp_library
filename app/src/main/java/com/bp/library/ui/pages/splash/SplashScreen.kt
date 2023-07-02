package com.bp.library.ui.pages.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.trian.mvi.Navigation
import app.trian.mvi.ui.UIWrapper
import app.trian.mvi.ui.internal.UIContract
import app.trian.mvi.ui.internal.rememberUIController
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 19/03/22 - 20.54
 * site https://trian.app
 */
object Splash {
    const val routeName = "Splash"
}

@Navigation(
    route = Splash.routeName,
    viewModel = SplashViewModel::class
)
@Composable
fun SplashScreen(
    uiContract: UIContract<SplashState, SplashIntent, SplashAction>
) = UIWrapper(uiContract = uiContract){

}

@Preview
@Composable
fun PreviewPageSplashScreen() {
    BpLibraryTheme {
        SplashScreen(
            UIContract(
                controller = rememberUIController(),
                state = SplashState()
            )
        )
    }
}