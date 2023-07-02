package com.bp.library.ui.pages.signUp

import app.trian.mvi.ui.viewModel.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

):MviViewModel<SignUpState,SignUpIntent,SignUpAction>(SignUpState()) {
    override fun onAction(action: SignUpAction) {
//no empty
    }
}