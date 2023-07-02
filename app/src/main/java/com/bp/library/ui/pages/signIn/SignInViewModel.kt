package com.bp.library.ui.pages.signIn

import app.trian.mvi.ui.viewModel.MviViewModel
import com.bp.library.data.common.ResultState
import com.bp.library.domain.auth.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : MviViewModel<SignInState, SignInIntent, SignInAction>(
    SignInState()
) {
    private fun signInWithEmail()=asyncWithState {
        signInUseCase(email.text,password.text).onEach {
            when(it){
                is ResultState.Error -> {
                    //gagal
                }
                ResultState.Loading -> {
                    //loading
                }
                is ResultState.Result -> {
                    //sukses
                }
            }
        }
    }
    override fun onAction(action: SignInAction) {
        when (action) {
            SignInAction.SignInWithEmail -> signInWithEmail()
        }
    }
}