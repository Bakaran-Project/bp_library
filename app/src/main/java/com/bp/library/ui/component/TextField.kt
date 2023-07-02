package com.bp.library.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bp.library.R
import com.bp.library.ui.theme.BpLibraryTheme
import com.bp.library.ui.theme.Danger
import com.bp.library.ui.theme.Line

/**
 *
 * author Trian Damai
 * created_at 27/03/22 - 00.58
 * site https://trian.app
 */

@Composable
fun TextFieldPrimary(
    value:TextFieldValue,
    placeholder: String="",
    label:String="",
    enabled:Boolean=true,
    showObsecure:Boolean=false,
    onChange:(TextFieldValue)->Unit={}
) {
    var showPassword by remember {
        mutableStateOf(true)
    }
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            placeholder={
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.body2
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = Color.Transparent,
                errorBorderColor = Danger,
                backgroundColor = Line
            ),
            shape = RoundedCornerShape(
                size = 18.dp
            ),
            textStyle = MaterialTheme.typography.body2,
            enabled = enabled,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                if(showObsecure)
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Image(
                            painter = painterResource(id = if(showPassword) R.drawable.ic_eye_active else R.drawable.ic_eye),
                            contentDescription = "Show or hidden password")
                    }
            },
            visualTransformation =
            if(showObsecure)
                if(showPassword) VisualTransformation.None
                else PasswordVisualTransformation()
            else VisualTransformation.None
        )
    }
}

@Preview
@Composable
fun PreviewTextField() {
    BpLibraryTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(
                    all = 20.dp
                )
                .fillMaxSize()
        ) {
            TextFieldPrimary(
                value = TextFieldValue(text = ""),
                placeholder = "Masukkan E-mail anda",
                label = "Nama depan"
            )
        }
    }
}