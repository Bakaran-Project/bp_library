package com.bp.library.ui.pages.signIn

import android.os.Parcelable
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class SignInState(
    val email:@RawValue TextFieldValue= TextFieldValue(),
    val password:@RawValue TextFieldValue = TextFieldValue()
) : Parcelable
