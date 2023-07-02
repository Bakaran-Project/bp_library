package com.bp.library.ui.pages.onboard

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.mvi.Navigation
import app.trian.mvi.ui.UIWrapper
import app.trian.mvi.ui.internal.UIContract
import app.trian.mvi.ui.internal.rememberUIController
import com.bp.library.ui.component.ButtonPrimary
import com.bp.library.ui.component.ButtonSecondary
import com.bp.library.ui.pages.onboard.component.ItemOnboard
import com.bp.library.ui.pages.signIn.SignIn
import com.bp.library.ui.pages.signUp.SignUp
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.ui.theme.PrimaryLighter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/**
 * author Trian Damai
 * created_at 10/04/22 - 13.54
 * site https://trian.app
 */
object Onboard{
    const val routeName="Onboard"
    val itemsOnboard:  List<ItemOnboard> = listOf(
        ItemOnboard.Onboard1,
        ItemOnboard.Onboard2,
        ItemOnboard.Onboard3
    )
}

@Navigation(
    route=Onboard.routeName,
    viewModel = OnboardViewModel::class
)
@Composable
fun OnboardScreen(
    uiContract: UIContract<OnboardState, OnboardIntent, OnboardAction>
) = UIWrapper(uiContract = uiContract){
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HorizontalPager(state = pagerState, count = 3) {
                Image(
                    painter = painterResource(
                        id = Onboard.itemsOnboard[pagerState.currentPage].image
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(
                            fraction = 0.8f
                        ),
                    contentScale = ContentScale.FillHeight
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(
                            alpha = 0.6f
                        )
                    )
            ) {

            }
            ContentOnboard(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                pagerState = pagerState,
                item = Onboard.itemsOnboard[pagerState.currentPage],
                onLogin = {
                    navigator.navHost.navigate(SignIn.routeName) {
                        popUpTo(Onboard.routeName) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onRegister = {
                    navigator.navigate(SignUp.routeName)
                },
                onNext = {
                    scope.launch {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun ContentOnboard(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    item: ItemOnboard,
    onNext: () -> Unit,
    onRegister: () -> Unit,
    onLogin: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.3f)
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            )
            .background(
                MaterialTheme.colors.surface
            )
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Indicators(size = pagerState.pageCount, index = pagerState.currentPage)
        Text(
            text = item.title,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        if (pagerState.currentPage == 2) {
            Column {
                ButtonSecondary(
                    text = "Buat Akun"
                ) {
                    onRegister()
                }
                Spacer(modifier = Modifier.height(8.dp))
                ButtonPrimary(
                    text = "Masuk akun",
                ) {
                    onLogin()
                }
            }
        } else {
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            ButtonPrimary(text = "Lanjut") {
                onNext()
            }
        }


    }
}

@Composable
fun Indicator(m: Modifier = Modifier, isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = ""
    )
    Box(
        modifier = m
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color =
                if (isSelected)
                    MaterialTheme.colors.primary
                else PrimaryLighter
            )
    ) {

    }
}

@Composable
fun Indicators(m: Modifier = Modifier, size: Int, index: Int) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = m,
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }

}


@ExperimentalPagerApi
@Preview
@Composable
fun PreviewPageOnboard() {
    BpLibraryTheme {
        OnboardScreen(
            uiContract = UIContract(
                controller = rememberUIController(),
                state = OnboardState()
            )
        )
    }
}