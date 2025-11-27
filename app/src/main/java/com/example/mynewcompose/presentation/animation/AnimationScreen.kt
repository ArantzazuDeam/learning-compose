package com.example.mynewcompose.presentation.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.presentation.screen.detail.DetailScreen
import com.example.mynewcompose.presentation.screen.home.HomeScreen
import com.example.mynewcompose.ui.theme.Green60
import com.example.mynewcompose.ui.theme.Purple100
import com.example.mynewcompose.ui.theme.greenEmerald
import com.example.mynewcompose.ui.theme.orangePeach
import com.example.mynewcompose.ui.theme.pinkPale
import com.example.mynewcompose.ui.theme.purpleDeep
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
        Spacer(Modifier.height(16.dp))
        MyAnimatedContentWithButton()
        Spacer(Modifier.height(16.dp))
        MyAnimatedContentSizeWithButton()
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun MyDividerForAnimation() {
    HorizontalDivider(
        thickness = 2.dp,
        color = Green60,
    )
}

@Composable
fun MyAnimatedHiddenViewWithButton() {
    var isViewShown by remember { mutableStateOf(true) }
    MyDividerForAnimation()
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
    MyDividerForAnimation()
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
    Spacer(Modifier.height(10.dp))
}

@Composable
fun MyCrossfade() {
    var currentScreen by remember { mutableStateOf("Home") }
    MyDividerForAnimation()
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

@Composable
fun MyAnimatedContentWithButton() {
    var number by remember { mutableIntStateOf(0) }
    MyDividerForAnimation()
    Button(onClick = { number++ }) {
        Text(text = "Sumar")
    }
    Text(text = if (number < 4) "Valor actual: $number)" else "Valor actual: $number. (Ya no sigas que es pa ná)")
    Spacer(Modifier.height(10.dp))
    MyAnimatedContent(number)
}

@Composable
fun MyAnimatedContent(number: Int) {
    AnimatedContent(targetState = number) { result ->
        when (result) {
            0 ->
                Box(
                    Modifier
                        .size(50.dp)
                        .background(Color.Red),
                )

            1 -> Text("Ahora tengo el valor 1")
            2 -> FloatingActionButton(onClick = {}) { }
            3 ->
                Box(
                    Modifier
                        .size(60.dp)
                        .background(purpleDeep),
                )

            else -> Text("Fin de animar")
        }
    }
}

@Composable
fun MyAnimatedContentSizeWithButton() {
    var expanded by remember { mutableStateOf(false) }
    MyDividerForAnimation()
    Button(onClick = { expanded = !expanded }) {
        Text(text = if (expanded) "Colapsar" else "Expandir")
    }
    Spacer(Modifier.height(10.dp))
    MyAnimatedSizeContent(expanded)
}

@Composable
fun MyAnimatedSizeContent(expanded: Boolean) {
    Box(
        Modifier
            .background(purpleDeep)
            .fillMaxWidth()
            .animateContentSize()
            .height(if (expanded) 300.dp else 150.dp)
            .padding(horizontal = 12.dp),
    ) {
        Text(
            text =
                "Prow scuttle parrel provost Sail ho shrouds spirits boom mizzenmast yardarm. Pinnace holystone mizzenmast quarter crow's nest nipperkin grog yardarm hempen halter furl. Swab barque interloper chantey doubloon starboard grog black jack gangway rutters.\n" +
                    "\n" +
                    "Deadlights jack lad schooner scallywag dance the hempen jig carouser broadside cable strike colors. Bring a spring upon her cable holystone blow the man down spanker Shiver me timbers to go on account lookout wherry doubloon chase. Belay yo-ho-ho keelhaul squiffy black spot yardarm spyglass sheet transom heave to.\n" +
                    "\n" +
                    "Trysail Sail ho Corsair red ensign hulk smartly boom jib rum gangway. Case shot Shiver me timbers gangplank crack Jennys tea cup ballast Blimey lee snow crow's nest rutters. Fluke jib scourge of the seven seas boatswain schooner gaff booty Jack Tar transom spirits.",
            color = Purple100,
        )
    }
}
