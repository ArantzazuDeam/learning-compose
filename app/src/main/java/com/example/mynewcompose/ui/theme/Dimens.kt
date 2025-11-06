package com.example.mynewcompose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    // Column
    val columnPadding: Dp = 32.dp,
    val columnPaddingFromBaseline: Dp = 16.dp,
    val columnVerticalSpacing: Dp = 10.dp,
    // Spacer
    val spacerPadding: Dp = 6.dp,
    // BasicTextField
    val basicTextFieldPadding: Dp = 16.dp,
)

val DefaultDimens = Dimens()

internal val LocalDimens = staticCompositionLocalOf { DefaultDimens }
