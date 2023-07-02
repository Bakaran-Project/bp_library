package com.bp.library.ui.pages.splash

import android.os.Parcelable
import app.trian.mvi.ui.extensions.Empty
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class SplashState(
    val a:String=String.Empty
) : Parcelable
