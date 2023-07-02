package com.bp.library.ui.pages.onboard

import app.trian.mvi.ui.viewModel.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor():MviViewModel<OnboardState,OnboardIntent,OnboardAction>(
    OnboardState()
) {
    override fun onAction(action: OnboardAction) {
        //no empty
    }
}