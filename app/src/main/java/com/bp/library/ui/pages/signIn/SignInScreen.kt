package com.bp.library.ui.pages.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.trian.mvi.Navigation
import app.trian.mvi.ui.UIWrapper
import app.trian.mvi.ui.internal.UIContract
import app.trian.mvi.ui.internal.rememberUIController
import com.bp.library.ui.component.ButtonGoogle
import com.bp.library.ui.component.ButtonPrimary
import com.bp.library.ui.component.RichText
import com.bp.library.ui.component.TextFieldPrimary
import com.bp.library.ui.pages.signUp.SignUp
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 27/03/22 - 20.00
 * site https://trian.app
 */
object SignIn{
    const val routeName = "SignIn"
}

@Navigation(
    route = SignIn.routeName,
    viewModel = SignInViewModel::class
)
@Composable
fun SignInScreen(
    uiContract: UIContract<SignInState, SignInIntent, SignInAction>
) = UIWrapper(uiContract = uiContract) {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(
                    all = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Selamat Datang Kembali",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 21.sp
                )
            )
            Text(
                text = "Masuk akun untuk dapat menggunakan kembali aplikasi",
                style = MaterialTheme.typography.subtitle2.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldPrimary(
                value = state.email,
                label = "Email",
                placeholder = "masukkkan email",
                onChange = {
                    commit { copy(email = it) }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextFieldPrimary(
                value = state.password,
                label = "Password",
                placeholder = "masukkkan password",
                showObsecure = true,
                onChange = {
                    commit { copy(password = it) }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                RichText(
                    text = "Lupa kata sandi?",
                    annotatedText = "Reset disini",
                    onCLick = {}
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            ButtonPrimary(
                text = "Masuk akun"
            ) {
                dispatch(SignInAction.SignInWithEmail)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Atau dengan")
            Spacer(modifier = Modifier.height(20.dp))
            ButtonGoogle(
                text = "Masuk Lewat Google"
            ) {
                navigator.navigate(SignUp.routeName)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPageLogin() {
    BpLibraryTheme {
        SignInScreen(
            UIContract(
                controller = rememberUIController(),
                state = SignInState()
            )
        )
    }
}