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
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 21.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
    ),
    button = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    ),
    caption = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    ),

)