package com.example.mynewcompose.presentation.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.presentation.screen.detail.DetailScreen
import com.example.mynewcompose.presentation.screen.home.HomeScreen
import com.example.mynewcompose.ui.theme.greenEmerald
import com.example.mynewcompose.ui.theme.orangePeach
import com.example.mynewcompose.ui.theme.pinkPale
import com.example.mynewcompose.ui.theme.yellowVanilla

@Composable
fun AnimationScreen() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(yellowVanilla)
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(60.dp))
        Text("Animaciones", fontSize = 30.sp)
        Spacer(Modifier.height(16.dp))
        MyAnimatedHiddenViewWithButton()
        Spacer(Modifier.height(16.dp))
        FullAnimateAsStateWithButton()
        Spacer(Modifier.height(16.dp))
        MyCrossfade()
    }
}

@Composable
fun MyAnimatedHiddenViewWithButton() {
    var isViewShown by remember { mutableStateOf(true) }
    Button(onClick = { isViewShown = !isViewShown }) {
        Text(text = if (isViewShown) "Ocultar" else "Mostrar")
    }
    Spacer(Modifier.height(10.dp))
    MyAnimatedHiddenView(isViewShown)
}

@Composable
fun MyAnimatedHiddenView(isViewShown: Boolean) {
    AnimatedVisibility(
        visible = isViewShown,
        enter = scaleIn(),
        exit = scaleOut() + fadeOut(),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(horizontal = 20.dp)
                    .background(pinkPale),
            contentAlignment = Alignment.Center,
        ) {
            Text("Ahora me ves")
        }
    }
}

@Composable
fun FullAnimateAsStateWithButton() {
    var isSelected by remember { mutableStateOf(true) }
    val animatedFloat by animateFloatAsState(
        targetValue = if (isSelected) 0.1f else 1f,
    )
    Button(onClick = { isSelected = !isSelected }) {
        Text(text = if (isSelected) "Hazlo pequeño" else "Hazlo grande")
    }
    Text(text = "Float: %.2f".format(animatedFloat))
    Spacer(Modifier.height(10.dp))
    FullAnimateAsState(isSelected, animatedFloat)
}

@Composable
fun FullAnimateAsState(
    isSelected: Boolean,
    animatedFloat: Float,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) greenEmerald else orangePeach,
    )

    val animatedSize by animateDpAsState(
        targetValue = if (isSelected) 100.dp else 50.dp,
    )

    val animatedOffSet by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 50f) else Offset(0f, 0f),
    )

    Box(
        modifier =
            Modifier
                .offset(animatedOffSet.x.dp, animatedOffSet.y.dp)
                .size(animatedSize)
                .background(animatedColor.copy(animatedFloat)),
    )
}

@Composable
fun MyCrossfade() {
    var currentScreen by remember { mutableStateOf("Home") }
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(
                onClick = { currentScreen = "Home" },
            ) {
                Text("Home")
            }
            Button(
                onClick = { currentScreen = "Detail" },
            ) {
                Text("Detail")
            }
        }

        Crossfade(targetState = currentScreen) { screen ->
            when (screen) {
                "Home" -> HomeScreen(navigateBack = {}, navigateToDetail = { _, _ -> })
                "Detail" ->
                    DetailScreen(
                        id = "Prueba crossfade",
                        navigateToSettings = { },
                        navigateBack = { },
                    )
            }
        }
    }
}
