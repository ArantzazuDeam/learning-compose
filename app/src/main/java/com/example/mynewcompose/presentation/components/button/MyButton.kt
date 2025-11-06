package com.example.mynewcompose.presentation.components.button

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

// region Default
@Preview(
    showSystemUi = true,
)
@Composable
fun MyButtonParentPreview() {
    Scaffold { innerPadding ->
        MyButtonParent(
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}

@Composable
fun MyButtonParent(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(Dimens.columnPadding)
                .paddingFromBaseline(Dimens.columnPaddingFromBaseline)
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.columnVerticalSpacing),
    ) {
        MyBasicButtonExamples()
        MyOutlinedButtonExamples()
        MyTextButtonExamples()
        MyElevatedButtonExamples()
        MyFilledTonalButtonExamples()
    }
}

@Composable
fun MyBasicButtonExamples() {
    MyButtonTitle(stringResource(R.string.button))
    MyBasicButton()
    MyDisabledButton()
    MyRoundedButton()
    MyPercentageRoundedButton()
    MyBorderButton()
    MyBorderGradientButton()
    MyChangedColorsButton()
    MyDisabledChangedColorsButton()
    MyTextLeImportaUnFuckElContainerColorDefinidoEnElButton()
}

@Composable
fun MyOutlinedButtonExamples() {
    MyButtonTitle(stringResource(R.string.outlined_button))
    MyBasicOutlinedButton()
    MyPersonalizedOutlinedButton()
}

@Composable
fun MyTextButtonExamples() {
    MyButtonTitle(stringResource(R.string.text_button))
    MyTextButton()
    MyPersonalizedTextButton()
}

@Composable
fun MyElevatedButtonExamples() {
    MyButtonTitle(stringResource(R.string.elevated_button))
    MyElevatedButton()
    MyPersonalizedElevatedButton()
}

@Composable
fun MyFilledTonalButtonExamples() {
    MyButtonTitle(stringResource(R.string.filled_tonal_button))
    MyFilledTonalButton()
    MyPersonalizedFilledTonalButton()
}
// endregion

// region Button
@Composable
fun MyButtonTitle(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Start,
        fontSize = 28.sp,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun MyBasicButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_enabled)
    Button(
        onClick = { Log.i(logTag, logMsg) },
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyDisabledButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_disabled)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        enabled = false,
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyRoundedButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_rounded)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20.dp),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyPercentageRoundedButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_rounded_percentage)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyBorderButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_border)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Color.Magenta),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyBorderGradientButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_border_gradient)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyChangedColorsButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_colors_changed)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
        colors =
            ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.White,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyDisabledChangedColorsButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_colors_changed_disabled)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        enabled = false,
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
        colors =
            ButtonDefaults.buttonColors(
                contentColor = Color.Green,
                containerColor = Color.White,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

@Composable
fun MyTextLeImportaUnFuckElContainerColorDefinidoEnElButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_button_colors_text_le_importa_un_fuck)
    Button(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
        colors =
            ButtonDefaults.buttonColors(
                contentColor = Color.Green,
                containerColor = Color.White,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me), color = Color.Magenta)
    }
}

// endregion

// region OutlinedButton

@Composable
fun MyBasicOutlinedButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_outlined_button_basic)
    OutlinedButton(
        onClick = { Log.i(logTag, logMsg) },
    ) {
        Text(text = stringResource(R.string.button_tap_me), color = Color.Magenta)
    }
}

@Composable
fun MyPersonalizedOutlinedButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_outlined_button_colors)
    OutlinedButton(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
        colors =
            ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Green,
                containerColor = Color.Blue,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

// endRegion

// region TextButton
@Composable
fun MyTextButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_text_button_basic)
    TextButton(
        onClick = { Log.i(logTag, logMsg) },
    ) {
        Text(text = stringResource(R.string.button_tap_me), color = Color.Magenta)
    }
}

@Composable
fun MyPersonalizedTextButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_text_button_colors)
    TextButton(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
        colors =
            ButtonDefaults.textButtonColors(
                contentColor = Color.Green,
                containerColor = Color.Blue,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

// endregion

// region ElevatedButton
@Composable
fun MyElevatedButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_elevated_button_basic)
    ElevatedButton(
        onClick = { Log.i(logTag, logMsg) },
    ) {
        Text(text = stringResource(R.string.button_tap_me), color = Color.Magenta)
    }
}

@Composable
fun MyPersonalizedElevatedButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_elevated_button_colors)
    ElevatedButton(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        enabled = true,
        elevation =
            ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 6.dp,
                pressedElevation = 2.dp,
                disabledElevation = 0.dp,
            ),
        colors =
            ButtonDefaults.textButtonColors(
                contentColor = Color.Green,
                containerColor = Color.Blue,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}
// endregion

// region FilledTonalButton
@Composable
fun MyFilledTonalButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_filled_tonal_button_basic)
    FilledTonalButton(
        onClick = { Log.i(logTag, logMsg) },
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}

/*
* Este botón es una chorrada. Es lo MISMO que un botón normal,
* pero viene por defecto con un background con un color ligeramente más suavito que el color primario de la aplicación.
* Fin.
* */

@Composable
fun MyPersonalizedFilledTonalButton() {
    val logTag = stringResource(R.string.log_tag)
    val logMsg = stringResource(R.string.log_i_filled_tonal_button_colors)
    FilledTonalButton(
        onClick = { Log.i(logTag, logMsg) },
        shape = RoundedCornerShape(20),
        border = BorderStroke(3.dp, Brush.linearGradient(listOf(Color.Yellow, Color.Green))),
        colors =
            ButtonDefaults.textButtonColors(
                contentColor = Color.Green,
                containerColor = Color.Blue,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray,
            ),
    ) {
        Text(text = stringResource(R.string.button_tap_me))
    }
}
