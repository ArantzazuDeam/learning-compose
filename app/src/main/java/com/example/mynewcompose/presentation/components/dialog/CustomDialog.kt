package com.example.mynewcompose.presentation.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mynewcompose.presentation.components.model.PokemonCombat
import com.example.mynewcompose.ui.theme.Pink120
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.Pink60

@Composable
fun MyCustomDialogManager(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MyFirstCustomDialogManager("Abre un diálogo personalizado.")
    }
}

@Composable
fun MyFirstCustomDialogManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }

    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MyFirstCustomDialog(
            pokemonCombat = PokemonCombat("Bulbasur", "Charmander"),
            onDismiss = { showDialog = false },
            onConfirm = {
                // iniciar combate
                showDialog = false
            },
        )
    }
}

@Preview
@Composable
fun MyFirstCustomDialog(
    pokemonCombat: PokemonCombat = PokemonCombat("Pikachu", "Magikarp"),
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
) {
    Dialog(
        onDismissRequest = { onDismiss() },
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Pink120, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = pokemonCombat.pokemonA,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Pink40,
                )
                Text(text = "VS")
                Text(
                    text = pokemonCombat.pokemonB,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Pink40,
                )
            }
            Button(
                onClick = { onConfirm() },
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Pink60,
                    ),
            ) {
                Text(text = "FIGHT!")
            }
            TextButton(
                onClick = { onConfirm() },
            ) {
                Text(text = "No, mejor háganse amigos", color = Pink60)
            }
        }
    }
}
