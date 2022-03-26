package com.bp.library.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.R
import com.bp.library.ui.theme.Line

/**
 *
 * author Trian Damai
 * created_at 19/03/22 - 20.55
 * site https://trian.app
 */

@Composable
fun ButtonPrimary(
    modifier: Modifier=Modifier,
    text:String="Click Here",
    enabled:Boolean=true,
    onClick:()->Unit ={}
) {

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(
                minHeight = 50.dp
            ),
        shape = RoundedCornerShape(18.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonSecondary(
    modifier: Modifier=Modifier,
    text:String="Click Here",
    enabled:Boolean=true,
    onClick:()->Unit ={}
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(
                minHeight = 50.dp
            ),
        shape = RoundedCornerShape(18.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        )

    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonVariant(
    modifier: Modifier=Modifier,
    text:String="Click Here",
    enabled:Boolean=true,
    onClick:()->Unit ={}
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White.copy(
                alpha = 0.1f
            )
        ),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(
                minHeight = 50.dp
            ),
        shape = RoundedCornerShape(18.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonGoogle(
    modifier: Modifier=Modifier,
    text:String="Click Here",
    enabled:Boolean=true,
    onClick:()->Unit ={}
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Line
        ),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(
                minHeight = 50.dp
            ),
        shape = RoundedCornerShape(18.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        )
    ) {
        Box(
            modifier = modifier.fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Button Google",
                modifier = modifier.align(Alignment.CenterStart)
            )
            Text(
                text = text,
                modifier = modifier.align(Alignment.Center)
            )

        }
    }
}

@Preview
@Composable
fun PreviewButton() {
    BpLibraryTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colors.background)
                .padding(
                    all = 12.dp
                )
        ) {
            ButtonPrimary()
            Spacer(modifier = Modifier.height(20.dp))
            ButtonSecondary()
            Spacer(modifier = Modifier.height(20.dp))
            ButtonVariant()
            Spacer(modifier = Modifier.height(20.dp))
            ButtonGoogle()
        }
    }
}