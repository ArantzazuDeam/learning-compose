package com.example.mynewcompose.presentation.components.selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.R

@Preview(showSystemUi = true)
@Composable
fun MySwitchControlParentPreview() {
    Scaffold { innerPadding ->
        MyParentSwitchControl(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentSwitchControl(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        MyBasicSwitch()
        MySwitchDisabledChecked()
        MySwitchDisabledUnchecked()
        MySwitchIcon()
        MySwitchIconDisabledChecked()
        MySwitchIconDisabledUnchecked()
        MySwitchBorder()
        MySwitchBorderDisabledChecked()
        MySwitchBorderDisabledUnchecked()
        MySwitchTrack()
        MySwitchTrackDisabledChecked()
        MySwitchTrackDisabledUnchecked()
    }
}

// region Switch modificar bolita
@Composable
fun MyBasicSwitch() {
    var switchState by remember { mutableStateOf(true) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = it },
        thumbContent = {
            if (switchState) {
                Text(text = "I", color = Color.White)
            } else {
                Text("O", color = Color.White)
            }
        },
        colors =
            SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                uncheckedThumbColor = Color.Cyan,
            ),
    )
}

@Composable
fun MySwitchDisabledChecked() {
    Switch(
        checked = true,
        onCheckedChange = { },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledCheckedThumbColor = Color.Red,
            ),
    )
}

@Composable
fun MySwitchDisabledUnchecked() {
    Switch(
        checked = false,
        onCheckedChange = { },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledUncheckedThumbColor = Color.Magenta,
            ),
    )
}
// endregion

// region Switch modificar icono
@Composable
fun MySwitchIcon() {
    var switchState by remember { mutableStateOf(true) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = it },
        thumbContent = { MyPersonitaIcon() },
        colors =
            SwitchDefaults.colors(
                checkedIconColor = Color.Blue,
                uncheckedIconColor = Color.Cyan,
            ),
    )
}

@Composable
fun MySwitchIconDisabledChecked() {
    Switch(
        checked = true,
        onCheckedChange = { },
        thumbContent = { MyPersonitaIcon() },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledCheckedIconColor = Color.Red,
            ),
    )
}

@Composable
fun MySwitchIconDisabledUnchecked() {
    Switch(
        checked = false,
        onCheckedChange = { },
        thumbContent = { MyPersonitaIcon() },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledUncheckedIconColor = Color.Magenta,
            ),
    )
}

@Composable()
fun MyPersonitaIcon() {
    Icon(
        painter = painterResource(R.drawable.ic_personita),
        contentDescription = "",
    )
}
// endregion

// region Switch modificar borde
@Composable
fun MySwitchBorder() {
    var switchState by remember { mutableStateOf(true) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = it },
        colors =
            SwitchDefaults.colors(
                checkedBorderColor = Color.Blue,
                uncheckedBorderColor = Color.Cyan,
            ),
    )
}

@Composable
fun MySwitchBorderDisabledChecked() {
    Switch(
        checked = true,
        onCheckedChange = { },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledCheckedBorderColor = Color.Red,
            ),
    )
}

@Composable
fun MySwitchBorderDisabledUnchecked() {
    Switch(
        checked = false,
        onCheckedChange = { },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledUncheckedBorderColor = Color.Magenta,
            ),
    )
}
// endregion

// region Switch modificar track
@Composable
fun MySwitchTrack() {
    var switchState by remember { mutableStateOf(true) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = it },
        colors =
            SwitchDefaults.colors(
                checkedTrackColor = Color.Blue,
                uncheckedTrackColor = Color.Cyan,
            ),
    )
}

@Composable
fun MySwitchTrackDisabledChecked() {
    Switch(
        checked = true,
        onCheckedChange = { },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledCheckedTrackColor = Color.Red,
            ),
    )
}

@Composable
fun MySwitchTrackDisabledUnchecked() {
    Switch(
        checked = false,
        onCheckedChange = { },
        enabled = false,
        colors =
            SwitchDefaults.colors(
                disabledUncheckedTrackColor = Color.Magenta,
            ),
    )
}
// endregion
