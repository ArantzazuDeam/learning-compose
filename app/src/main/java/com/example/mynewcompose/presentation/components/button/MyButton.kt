package com.example.mynewcompose.presentation.components.button

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

@Preview(showSystemUi = true)
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
                .paddingFromBaseline(Dimens.columnPaddingFromBaseline),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.columnVerticalSpacing),
    ) {
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
