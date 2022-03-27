package com.bp.library.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.R
import com.bp.library.ui.component.ButtonSecondary
import com.bp.library.ui.component.ButtonVariant
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 27/03/22 - 19.49
 * site https://trian.app
 */

@Composable
fun PageOnboard(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
    Column(
        modifier= modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                MaterialTheme.colors.primary
            )
            .padding(
                all = 16.dp
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.welcome_to_maos))
            Text(text = stringResource(R.string.intro))
        }
        Column {

        }
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.privacy_policy_description))
            Spacer(modifier = modifier.height(10.dp))
            ButtonVariant(
                text = "Buat Akun"
            )
            ButtonSecondary(
                text = "Masuk"
            )
        }
    }
}

@Preview
@Composable
fun PreviewPageOnboard() {
    BpLibraryTheme {
        PageOnboard(router = rememberNavController())
    }
}