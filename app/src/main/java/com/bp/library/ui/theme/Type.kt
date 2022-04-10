package com.bp.library.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bp.library.R

val fontFamily = FontFamily(
    Font(
        R.font.mulish_black,
        FontWeight.Black,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_black_italic,
        FontWeight.Black,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_extra_bold,
        FontWeight.ExtraBold,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_extra_bold_italic,
        FontWeight.ExtraBold,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_bold,
        FontWeight.Bold,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_bold_italic,
        FontWeight.Bold,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_semi_bold,
        FontWeight.SemiBold,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_semi_bold_italic,
        FontWeight.SemiBold,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_regular,
        FontWeight.Normal,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_medium,
        FontWeight.Medium,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_medium_italic,
        FontWeight.Medium,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_light,
        FontWeight.Light,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_light_italic,
        FontWeight.Light,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_extra_light,
        FontWeight.ExtraLight,
        FontStyle.Normal
    ),
    Font(
        R.font.mulish_extra_light_italic,
        FontWeight.ExtraLight,
        FontStyle.Italic
    ),
    Font(
        R.font.mulish_italic,
        FontWeight.Thin,
        FontStyle.Italic
    ),

)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontFamily = fontFamily
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        fontFamily = fontFamily
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        fontFamily = fontFamily
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        fontFamily = fontFamily
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        fontFamily = fontFamily
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontFamily = fontFamily
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        fontFamily = fontFamily
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        fontFamily = fontFamily
    ),
    caption = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        fontFamily = fontFamily
    ),

)