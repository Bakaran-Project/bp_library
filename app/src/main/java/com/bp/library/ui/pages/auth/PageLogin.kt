package com.bp.library.ui.pages.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.Routes
import com.bp.library.ui.component.ButtonGoogle
import com.bp.library.ui.component.ButtonPrimary
import com.bp.library.ui.component.RichText
import com.bp.library.ui.component.TextFieldPrimary
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 27/03/22 - 20.00
 * site https://trian.app
 */
@Composable
fun PageLogin(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
   Scaffold {
       Column(
           modifier = modifier
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
           Spacer(modifier = modifier.height(20.dp))
           TextFieldPrimary(
               value = email,
               label = "Email",
               placeholder = "masukkkan email",
               onChange = {
                   email = it
               }
           )
           Spacer(modifier = modifier.height(8.dp))
           TextFieldPrimary(
               value = password,
               label = "Password",
               placeholder = "masukkkan password",
               showObsecure = true,
               onChange = {
                   password = it
               }
           )
           Spacer(modifier = modifier.height(8.dp))
           Row(
               modifier = modifier
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.End
           ) {
               RichText(
                   text = "Lupa kata sandi?",
                   annotatedText = "Reset disini",
                   onCLick = {}
               )
           }
           Spacer(modifier = modifier.height(20.dp))
           ButtonPrimary(
               text = "Masuk akun"
           ){
               router.navigate(Routes.REGISTER)
           }
           Spacer(modifier = modifier.height(20.dp))
           Text(text = "Atau dengan")
           Spacer(modifier = modifier.height(20.dp))
           ButtonGoogle(
               text = "Masuk Lewat Google"
           ){
               router.navigate(Routes.REGISTER)
           }
       }
   }
}

@Preview
@Composable
fun PreviewPageLogin() {
    BpLibraryTheme {
        PageLogin(router = rememberNavController())
    }
}