package com.bp.library.ui.pages.dashboard

import app.trian.mvi.ui.viewModel.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() :
    MviViewModel<DashboardState, DashboardIntent, DashboardAction>(
        DashboardState()
    ) {
    override fun onAction(action: DashboardAction) {
        //no empty
    }
}