package com.example.mynewcompose.presentation.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.presentation.components.badge.MyBadgeBox
import com.example.mynewcompose.ui.theme.Green100
import com.example.mynewcompose.ui.theme.Pink100
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.Pink60
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

@Composable
fun MyParentCard(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.columnVerticalSpacing),
    ) {
        MyCard()
        MyDisabledCard()
        MyElevatedCard()
        MyOutlinedCard()
    }
}

@Composable
fun MyCircleWorkingAsAnAvatar() {
    Box(
        modifier =
            Modifier
                .padding(16.dp)
                .size(75.dp)
                .clip(CircleShape)
                .background(Green100),
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            imageVector = Icons.Outlined.PersonOutline,
            contentDescription = null,
            tint = Color.Black,
        )
    }
}

@Composable
fun MyBasicContentCard(
    title: String,
    subtitle: String,
) {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = subtitle,
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            color = Pink60,
            lineHeight = 16.sp,
        )
    }
}

@Composable
fun MyCard() {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors =
            CardDefaults.cardColors(
                containerColor = Pink100,
                contentColor = Pink40,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Black,
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 12.dp,
                pressedElevation = 2.dp,
                focusedElevation = 2.dp,
                disabledElevation = 0.dp,
            ),
        border =
            BorderStroke(
                width = 2.dp,
                color = Pink40,
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyBadgeBox()
            MyCircleWorkingAsAnAvatar()
            MyBasicContentCard(
                title = "Arantzazu De Alba",
                subtitle = "Arantxa es software engineer con 5 años de experiencia desarrollando aplicaciones móviles en Android.",
            )
        }
    }
}

@Composable
fun MyDisabledCard() {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors =
            CardDefaults.cardColors(
                containerColor = Pink100,
                contentColor = Pink40,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Black,
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 12.dp,
                pressedElevation = 2.dp,
                focusedElevation = 2.dp,
                disabledElevation = 0.dp,
            ),
        border =
            BorderStroke(
                width = 2.dp,
                color = Pink40,
            ),
        onClick = {},
        enabled = false,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyCircleWorkingAsAnAvatar()
            MyBasicContentCard(
                title = "Alexis Aparicio",
                subtitle = "Alexis es técnico informático titulado con matrícula de honor en SMR y actualmente está estudiando el CFGS de DAM.",
            )
        }
    }
}

@Composable
fun MyElevatedCard() {
    ElevatedCard(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors =
            CardDefaults.cardColors(
                containerColor = Pink100,
                contentColor = Pink40,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Black,
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 12.dp,
                pressedElevation = 2.dp,
                focusedElevation = 2.dp,
                disabledElevation = 0.dp,
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyCircleWorkingAsAnAvatar()
            MyBasicContentCard(
                title = "Javier Ruiz",
                subtitle = "Javi es software engineer con 6 años de experiencia desarrollando aplicaciones móviles en Android.",
            )
        }
    }
}

@Composable
fun MyOutlinedCard() {
    OutlinedCard(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors =
            CardDefaults.cardColors(
                containerColor = Pink100,
                contentColor = Pink40,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Black,
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 12.dp,
                pressedElevation = 2.dp,
                focusedElevation = 2.dp,
                disabledElevation = 0.dp,
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyCircleWorkingAsAnAvatar()
            MyBasicContentCard(
                title = "Leonor Moreno",
                subtitle = "Leo tiene una extensa experiencia en el cuidado de la familia y el hogar. Es una deportista activa y practica yoga desde hace más de 5 años.",
            )
        }
    }
}
