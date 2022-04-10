package com.bp.library.ui.pages.onboard

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.R
import com.bp.library.Routes
import com.bp.library.ui.component.ButtonPrimary
import com.bp.library.ui.component.ButtonSecondary
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.ui.theme.PrimaryLighter
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

/**
 * author Trian Damai
 * created_at 10/04/22 - 13.54
 * site https://trian.app
 */

@ExperimentalPagerApi
@Composable
fun PageOnboard(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
    val pagerState = rememberPagerState(pageCount = 3)
    val scope = rememberCoroutineScope()
    val itemsOnboard = listOf(
        ItemOnboard.Onboard1,
        ItemOnboard.Onboard2,
        ItemOnboard.Onboard3
    )

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            HorizontalPager(state = pagerState) {
                Image(
                    painter = painterResource(
                        id = itemsOnboard[pagerState.currentPage].image
                    ),
                    contentDescription = "",
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight(
                            fraction = 0.8f
                        ),
                    contentScale = ContentScale.FillHeight
                )
            }

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(
                            alpha = 0.6f
                        )
                    )
            ) {

            }
            ContentOnboard(
                modifier = modifier
                    .align(Alignment.BottomCenter),
                pagerState = pagerState,
                item = itemsOnboard[pagerState.currentPage],
                onLogin = {
                          router.navigate(Routes.LOGIN){
                              popUpTo(Routes.ONBOARD){
                                  inclusive=true
                              }
                              launchSingleTop=true
                          }
                },
                onRegister = {
                    router.navigate(Routes.REGISTER)
                },
                onNext = {
                    scope.launch {
                        pagerState.scrollToPage(pagerState.currentPage+1)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun ContentOnboard(
    modifier: Modifier=Modifier,
    pagerState: PagerState,
    item:ItemOnboard,
    onNext:()->Unit,
    onRegister:()->Unit,
    onLogin:()->Unit
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
            modifier = modifier.fillMaxWidth()
        )
        if(pagerState.currentPage == 2) {
           Column {
               ButtonSecondary(
                   text = "Buat Akun"
               ){
                   onRegister()
               }
               Spacer(modifier = modifier.height(8.dp))
               ButtonPrimary(
                   text = "Masuk akun",
               ){
                   onLogin()
               }
           }
        }else{
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
            ButtonPrimary(text = "Lanjut"){
               onNext()
            }
        }


    }
}
@Composable
fun Indicator(m: Modifier = Modifier, isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
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

sealed class ItemOnboard(
    var image:Int,
    var title:String,
    var subtitle:String
){
    object Onboard1:ItemOnboard(
        image = R.drawable.onboard1,
        title = "Pinjam buku perpustakaan lebih mudaj dan fleksibel",
        subtitle = "Lorem ipsum dolor sit amet, consectus adipsting eit. Cros nisl nunc mouris sed fementum figikal dul."
    )

    object Onboard2:ItemOnboard(
        image = R.drawable.onboard2,
        title = "Masuk perpustkaan dengan beberapa klik",
        subtitle = "Lorem ipsum dolor sit amet, consectus adipsting eit. Cros nisl nunc mouris sed fementum figikal dul."
    )

    object Onboard3:ItemOnboard(
        image = R.drawable.onboard3,
        title = "Akses buku-buku perpustakaan sekarang!",
        subtitle = ""
    )
}

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewPageOnboard() {
    BpLibraryTheme {
        PageOnboard(router = rememberNavController())
    }
}