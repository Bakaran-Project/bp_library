package com.bp.library.ui.pages.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.ui.theme.BpLibraryTheme

/**
 *
 * author Trian Damai
 * created_at 26/03/22 - 20.29
 * site https://trian.app
 */
@Composable
fun PageBookmark(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
    BaseDashboard(router = router)
}

@Preview
@Composable
fun PreviewPageBookmark() {
    BpLibraryTheme {
        PageBookmark(router = rememberNavController())
    }
}