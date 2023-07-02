package com.bp.library.ui.pages.splash

import app.trian.mvi.ui.UIEvent
import app.trian.mvi.ui.viewModel.MviViewModel
import com.bp.library.ui.pages.onboard.Onboard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : MviViewModel<SplashState, SplashIntent, SplashAction>(
    SplashState()
) {
    init {
        checkSession()
    }

    private fun checkSession() = async {
        sendUiEvent(UIEvent.NavigateAndReplace(Onboard.routeName))
    }

    override fun onAction(action: SplashAction) {
//no empty
    }
}