package com.bp.library.ui.pages.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bp.library.ui.component.HeaderHome
import com.bp.library.ui.component.ItemBook
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.ui.theme.SecondaryDarker

/**
 * author Trian Damai
 * created_at 26/03/22 - 20.27
 * site https://trian.app
 */
@Composable
fun PageHome(
    modifier: Modifier = Modifier,
    router: NavHostController
) {
    BaseDashboard(
        router = router,
        body = {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.4f)
                        .background(MaterialTheme.colors.primary),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                }
                LazyColumn(
                    content = {
                        item {
                            Box {
                                Column {
                                    Spacer(modifier = modifier.height(200.dp))
                                    Column(
                                        modifier = modifier
                                            .fillMaxWidth()
                                            .height(300.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topEnd = 20.dp,
                                                    topStart = 20.dp
                                                )
                                            )
                                            .background(MaterialTheme.colors.surface)
                                    ) {

                                    }
                                }
                                    Column(
                                        modifier = modifier
                                            .padding(
                                                horizontal = 16.dp
                                            )
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Top
                                    ) {
                                        Spacer(modifier = modifier.height(20.dp))
                                        Text(
                                            text = "Halo, Juan pablo!",
                                            style = MaterialTheme.typography.h2,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                        Text(
                                            text = "Explore buku perpustakaan dengan mudah",
                                            style = MaterialTheme.typography.body1,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                        Spacer(modifier = modifier.height(16.dp))
                                        Row(
                                            modifier = modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 8.dp),
                                            horizontalArrangement = Arrangement.Start
                                        ) {
                                            Text(text = "Coba \"Harry Potter\" ")
                                        }
                                        Spacer(modifier = modifier.height(16.dp))
                                        HeaderHome()
                                    }


                            }

                        }
                        item {
                            Column(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.4f)
                                    .background(MaterialTheme.colors.surface)
                            ) {

                            }
                        }
                        item {
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colors.surface)
                                    .padding(
                                        horizontal = 16.dp,
                                        vertical = 8.dp
                                    ),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Rekomendasi Untukmu",
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Semuanya",
                                    style = MaterialTheme.typography.body1,
                                    color = SecondaryDarker
                                )
                            }
                            LazyRow(
                                modifier =  modifier
                                    .background(MaterialTheme.colors.surface),
                                content = {
                                items(count = 5){
                                    index->
                                    ItemBook(
                                        bookTitle = "The Answer",
                                        bookDescription = "Allan & Barbara pease",
                                        marginStart = if(index == 0) 16.dp else 0.dp,
                                        marginEnd = 8.dp
                                    )
                                }
                            })
                        }
                    }
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewPageHome() {
    BpLibraryTheme {
        PageHome(router = rememberNavController())
    }
}