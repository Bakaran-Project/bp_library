package com.bp.library.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bp.library.R
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.ui.theme.Disable
import com.bp.library.ui.theme.SecondaryDarker
import com.bp.library.ui.theme.Subheading

/**
 * author Trian Damai
 * created_at 10/04/22 - 22.34
 * site https://trian.app
 */

@Composable
fun HeaderHome(
    modifier: Modifier=Modifier
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .shadow(
            elevation = 10.dp,
            clip = true
        )
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colors.surface)
        .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Disable.copy(alpha = 0.6f))
                .padding(
                    all = 10.dp
                )
        ) {
            Text(
                text = "Ada beberapa buku yang kamu pinjam, jangan lupa kembalikan tepat waktu!"
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.dummy_book3),
                contentDescription = "",
                modifier = modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = modifier.width(10.dp))
            Column(
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Ego is The Enemy",
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = "Hari 2 dari 7",
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Spacer(modifier = modifier.height(16.dp))
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Selengkapnya",
                style = MaterialTheme.typography.h3,
                color = SecondaryDarker
            )
        }
    }
}

@Preview
@Composable
fun PreviewHeaderHome() {
    BpLibraryTheme {
        HeaderHome()
    }
}