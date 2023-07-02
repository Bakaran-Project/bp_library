package com.bp.library.ui.pages.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
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
import com.bp.library.ui.pages.dashboard.Dashboard
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 27/03/22 - 20.01
 * site https://trian.app
 */

object SignUp{
    const val routeName="SignUp"
}

@Navigation(
    route = SignUp.routeName,
    viewModel = SignUpViewModel::class
)
@Composable
fun SignUpScreen(
    uiContract: UIContract<SignUpState,SignUpIntent,SignUpAction>
) = UIWrapper(uiContract = uiContract){
    Scaffold {
        Column(
            modifier = Modifier.padding(it)
                .fillMaxSize()
                .padding(
                    all = 16.dp
                )
            ,
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
                value = TextFieldValue(""),
                label = "Nama Depan",
                placeholder = "masukkkan nama depan"
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextFieldPrimary(
                value = TextFieldValue(""),
                label = "Nama Belakang",
                placeholder = "masukkkan nama belakan"
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextFieldPrimary(
                value = TextFieldValue(""),
                label = "Email",
                placeholder = "masukkkan email"
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextFieldPrimary(
                value = TextFieldValue(""),
                label = "Password",
                placeholder = "masukkkan password",
                showObsecure = true
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonPrimary(
                text = "Masuk akun"
            ){
                navigator.navigate(Dashboard.routeName)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Atau dengan")
            Spacer(modifier = Modifier.height(20.dp))
            ButtonGoogle(
                text = "Masuk Lewat Google"
            ){
                navigator.navigate(Dashboard.routeName)
            }
            Spacer(modifier = Modifier.height(20.dp))

            RichText(
                text = "Sudah punya akun?",
                annotatedText = "Masuk disini",
                onCLick = {}
            )

        }
    }
}

@Preview
@Composable
fun PreviewPageRegister() {
    BpLibraryTheme {
        SignUpScreen(uiContract = UIContract(
            controller = rememberUIController(),
            state= SignUpState()
        ))
    }
}