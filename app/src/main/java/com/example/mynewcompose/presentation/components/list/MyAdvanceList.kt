package com.example.mynewcompose.presentation.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.ui.theme.Pink120
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.Pink60

@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    val generatedList = List(100) { "Item número $it" }
    var myListState: List<String> by remember { mutableStateOf(generatedList) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // asignar una KEY es obligatorio si modificas listas, porque en caso contrario daría muchos problemas (puedes pulsar en una fila y ver como se borra otra)
        // Recomendación: Ponerla SIEMPRE, porque optimiza y son buenas prácticas.
        // ESO SÍ: Si hay dos valores iguales, crashea, porque la key debe ser única
        itemsIndexed(myListState, key = { _, item -> item }) { index, item ->
            Row {
                Text("$item; Índice: $index")
                Spacer(Modifier.weight(1f))
                TextButton(
                    onClick = {
                        myListState =
                            myListState.toMutableList().apply {
                                remove(item)
                            }
                    },
                ) {
                    Text(text = "Borrar")
                }
                Spacer(Modifier.width(24.dp))
            }
        }
    }
}

@Composable
fun MySecondAdvanceList(modifier: Modifier = Modifier) {
    val generatedList = List(100) { "Item número $it" }
    var myListState: List<String> by remember { mutableStateOf(generatedList) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "LazyColumn avanzao",
                    fontSize = 30.sp,
                    color = Pink60,
                )
                TextButton(
                    onClick = {
                        myListState = myListState.toMutableList().apply { add(0, "Soy el nuevo elemento.") }
                    }, // no puedo añadir más de un elemento a la lista. Si lo hago, la app crasheará porque la key no cambia
                ) {
                    Text("Añadir item")
                }
            }
        }
        itemsIndexed(myListState, key = { _, item -> item }) { index, item ->
            Row(
                modifier = Modifier.background(Pink120),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("$item; Índice: $index", color = Pink40)
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = {
                        myListState =
                            myListState.toMutableList().apply {
                                removeAt(index) // hace exactamente lo mismo que el composable de arriba
                            }
                    },
                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor = Pink60,
                        ),
                ) {
                    Text(text = "Borrar")
                }
                Spacer(Modifier.width(24.dp))
            }
        }
    }
}
