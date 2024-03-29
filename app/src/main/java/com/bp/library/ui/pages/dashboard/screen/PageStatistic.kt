package com.bp.library.ui.pages.dashboard.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 26/03/22 - 20.28
 * site https://trian.app
 */
@Composable
fun PageStatistic(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
//no empty
}

@Preview
@Composable
fun PreviewPageStatistic() {
    BpLibraryTheme {
        PageStatistic(router = rememberNavController())
    }
}