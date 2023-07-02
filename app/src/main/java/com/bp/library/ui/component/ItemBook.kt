package com.bp.library.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bp.library.R
import com.bp.library.ui.theme.BpLibraryTheme

/**
 * author Trian Damai
 * created_at 10/04/22 - 14.57
 * site https://trian.app
 */

@Composable
fun ItemBook(
    modifier: Modifier=Modifier,
    bookTitle:String,
    bookDescription:String,
    marginStart:Dp=0.dp,
    marginEnd:Dp=0.dp,
    onClick:()-> Unit={}
) {
    val ctx = LocalContext.current
    val currentWidth = ctx
        .resources
        .displayMetrics.widthPixels.dp /
            LocalDensity.current.density
    val cardWidth = currentWidth/3
    Row {
        Spacer(modifier = modifier.width(marginStart))
        Column(
            modifier = modifier
                .width(cardWidth)
                .clip(RoundedCornerShape(10.dp))
                .clickable(
                    onClick = onClick
                )
                .background(Color.Transparent)
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                )
        ) {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(10.dp)),
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.dummy_book1
                    ),
                    contentDescription = "",
                    modifier= modifier
                        .height(cardWidth + 10.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            Spacer(modifier = modifier.height(10.dp))
            Column {
                Text(
                    text = bookTitle,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = bookDescription,
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Spacer(modifier = modifier.width(marginEnd))
    }
}

@Preview
@Composable
fun PreviewItemBook() {
    BpLibraryTheme {
        ItemBook(
            bookTitle = "Ego is the Enemy",
            bookDescription = "Ryam Holiday"
        )
    }
}