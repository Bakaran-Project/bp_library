package com.bp.library.ui.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.bp.library.ui.theme.fontFamily

/**
 *
 * author Trian Damai
 * created_at 27/03/22 - 01.25
 * site https://trian.app
 */

@Composable
fun RichText(
    text:String,
    annotatedText:String,
    onCLick:()->Unit={}
) {


    val annotationStringForgotPassword = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onBackground,
                fontFamily = fontFamily
            )
        ){
            append(text)
        }
        append(" ")
        pushStringAnnotation(
            tag = "click",
            annotation = "click"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontFamily = fontFamily
            )
        ){
            append(annotatedText)
        }
        pop()
    }
    ClickableText(
        text = annotationStringForgotPassword,
        onClick = {
                offset->
            annotationStringForgotPassword.getStringAnnotations(
                tag = "click",
                start = offset,
                end = offset
            ).firstOrNull()?.let { _ ->
               onCLick()

            }
        }
    )
}