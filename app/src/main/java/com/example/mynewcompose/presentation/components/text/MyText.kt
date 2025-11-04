package com.example.mynewcompose.presentation.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.foundation.text.contextmenu.modifier.filterTextContextMenuComponents
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true)
@Composable
fun MyText() {
    Column(modifier = Modifier.padding(30.dp)) {
        Text("Texto con estilo por defecto")
        Text(text = "Este texto es de color rojo", color = Color.Red)
        Text("Este texto es grande", fontSize = 36.sp)
        Text("Este texto está en negrita", fontWeight = FontWeight.ExtraBold)
        Text("Este texto está en cursiva", fontStyle = FontStyle.Italic)
        Text("Voy a dejar espacio entre las letritas", letterSpacing = 6.sp)
        Text("Texto subrayado", textDecoration = TextDecoration.Underline)
        Text("Texto tachado", textDecoration = TextDecoration.LineThrough)
        Text(
            "Texto subrayado y tachado",
            textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline, TextDecoration.LineThrough)),
        )
        Text(
            "Texto subrayado y tachado, pero más simple",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough,
        )
        Text(
            "Un link de to la vida",
            color = Color.Blue,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { /* TODO: Que muestre un toast o algo */ },
        )
        Text("Texto subrayado con el fondo fosforito", modifier = Modifier.background(Color.Yellow))
        Text(
            "Texto subrayado con el fondo cyan, que ocupa todo el ancho del padre",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
        )
        Text(
            "Texto subrayado con el fondo verde, que ocupa todo el ancho del padre  y está alineado en el centro",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
            textAlign = TextAlign.Center,
        )
        Text(
            "Texto subrayado con el fondo magenta, que ocupa todo el ancho del padre pero no se lee entero porque es muy largo y lo hemos limitado a una única línea (y está alineado en el centro aunque eso no valga pa na)",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
