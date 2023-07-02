package com.bp.library.ui.pages.signIn

sealed interface SignInAction {
    object SignInWithEmail : SignInAction
}