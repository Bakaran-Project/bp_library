package com.bp.library.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bp.library.R
import com.bp.library.Routes
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.ui.theme.PrimaryDarker
import com.bp.library.ui.theme.SecondaryDarker
import com.bp.library.ui.theme.Subheading
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * author Trian Damai
 * created_at 26/03/22 - 19.37
 * site https://trian.app
 */
@Composable
fun BpBottomNavigation(
    modifier: Modifier=Modifier,
    router:NavHostController,
) {
    val ctx = LocalContext.current
    val currentWidth = ctx
        .resources
        .displayMetrics.widthPixels.dp /
            LocalDensity.current.density

    val widthItem = currentWidth/5
    val bottomNavigationHeight = currentWidth / 6
    val navBackStackEntry by router.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        BottomNavigationContent.Home,
        BottomNavigationContent.Statistic,
        BottomNavigationContent.Scanner,
        BottomNavigationContent.Bookmark,
        BottomNavigationContent.Profile,
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(bottomNavigationHeight + 6.dp)
    ) {
        Row(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(bottomNavigationHeight)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .padding(
                    bottom = 4.dp
                )
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationItems.forEach {
                if(it.isFab){
                    Column(
                        modifier = modifier
                            .width(widthItem),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                    }
                }else {
                    Column(
                        modifier = modifier
                            .height(bottomNavigationHeight)
                            .width(widthItem)
                            .clickable {
                                router.navigate(it.route){
                                    launchSingleTop = true
                                }
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = modifier
                                .width(widthItem/2)
                                .height(3.dp)
                                .background(if(currentRoute == it.route) PrimaryDarker else Color.White)
                        ) {

                        }
                        Image(
                            painter = painterResource(id = if(currentRoute == it.route) it.activeIcon else it.icon),
                            contentDescription = "Go to ${it.route}"
                        )
                        Text(
                            text = stringResource(id = it.title),
                            style = MaterialTheme.typography.subtitle1.copy(
                                color = if(currentRoute == it.route) PrimaryDarker else Subheading
                            )
                        )
                    }
                }
            }
        }
        //FAB
        Column(
            modifier = modifier
                .size(widthItem-widthItem / 4)
                .border(
                    border = BorderStroke(
                        width = 3.dp,
                        color = Color.White
                    ),
                    shape = CircleShape
                )
                .clip(CircleShape)
                .clickable {  }
                .background(SecondaryDarker)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_scanner_active),
                contentDescription = "Scan"
            )
        }
    }

}
sealed class BottomNavigationContent(
    val title:Int,
    val route:String,
    val icon:Int,
    val activeIcon:Int,
    val isFab:Boolean=false
){
    object Home:BottomNavigationContent(
        R.string.dashboard,
        Routes.Dashboard.HOME,
        R.drawable.ic_book,
        R.drawable.ic_book_active,
    )
    object Statistic:BottomNavigationContent(
        R.string.statistic,
        Routes.Dashboard.STATISTIC,
        R.drawable.ic_chart_2,
        R.drawable.ic_chart_2_active,
    )
    object Scanner:BottomNavigationContent(
        R.string.statistic,
        Routes.Dashboard.STATISTIC,
        R.drawable.ic_scanner,
        R.drawable.ic_scanner_active,
        true
    )
    object Bookmark:BottomNavigationContent(
        R.string.bookmark,
        Routes.Dashboard.BOOKMARK,
        R.drawable.ic_bookmark,
        R.drawable.ic_bookmark_active
    )
    object Profile:BottomNavigationContent(
        R.string.profile,
        Routes.Dashboard.PROFILE,
        R.drawable.ic_profile,
        R.drawable.ic_profile_active,
    )
}

@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewBpBottomNavigation() {
    BpLibraryTheme {
        BpBottomNavigation(
            router =  rememberAnimatedNavController()
        )
    }
}