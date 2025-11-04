package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    name = "Prueba Preview",
    showBackground = true, // Muestra el fondo, limitándose al elemento contenido
    showSystemUi = true, // Muestra el componente situado en el dispositivo
    apiLevel = 32, // cambia como se visualiza el componente según el nivel de api de android
    device = Devices.PIXEL_9_PRO
)
@Composable
fun MyTestSuperText() {
    MySuperText("no lo sé.")
}

@Composable
fun MySuperText(name: String) {
    Text(
        text = "Yo soy Arantxa pero tú $name",
        modifier = Modifier.fillMaxSize() // equivalente a match_parent (pero match_parent está obsoleto)
            .padding(horizontal = 50.dp, vertical = 130.dp) // ya no existen los margins, solo paddings
            .clickable {
                // Lo que se meta aquí dentro convierte el texto en clickable.
            }
    )
}