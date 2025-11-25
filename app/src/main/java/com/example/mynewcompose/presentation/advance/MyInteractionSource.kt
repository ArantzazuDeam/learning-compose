package com.example.mynewcompose.presentation.advance

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * El InteractionSource es la fuente de interacción.
 * Nos permite saber el estado de un botón o cualquier composable (presionado, hover, etc.)
 * La variable interaction del siguiente Composable es de tipo MutableInteractionSource.
 * Poemos obtener cuatro estados diferentes:
 * collectIsPressedAsState -> Para cuando el elemento está siendo pulsado.
 * collectIsDraggedAsState -> Para cuando el elemento está siendo arrastrado.
 * collectIsFocusedAsState -> Para cuando el elemento tiene el foco.
 * collectIsHoveredAsState -> Para cuando el ratón por encima (en android nativo no tiene mucho nativo, es más para Kotlin Multi Platform (KMP)).
 */
@Composable
fun InteractionSourceExample(modifier: Modifier = Modifier) {
    val interaction = remember { MutableInteractionSource() }
    val isPressed by interaction.collectIsPressedAsState()

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .size(150.dp)
                    .shadow(if (isPressed) 0.dp else 14.dp)
                    .background(if (isPressed) Color.Red else Color.White)
                    .clickable(
                        interactionSource = interaction,
                        indication = null, // ya no tiene ripple (el efecto de color que tiene cuando se pulsa y se despulsa)
                    ) {},
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = if (isPressed) "Está pulsado." else "No está pulsado.",
            )
        }

        Box(
            modifier =
                Modifier
                    .size(150.dp)
                    .shadow(if (isPressed) 0.dp else 14.dp)
                    .background(Color.White)
                    .clickable(
                        interactionSource = interaction,
                        indication = LocalIndication.current, // ya no tiene ripple (el efecto de color que tiene cuando se pulsa y se despulsa)
                    ) {},
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Si pulsas tiene un parpadeo/cambio de color fugaz (como los botones). Eso es el ripple",
                textAlign = TextAlign.Center,
            )
        }

        Button(
            onClick = {},
            interactionSource = interaction,
        ) {
            Text(
                text = "Ejemplito",
            )
        }
    }
}
