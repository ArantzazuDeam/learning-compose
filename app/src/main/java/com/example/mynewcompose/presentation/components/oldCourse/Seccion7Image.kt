package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.MyOldComposeTheme

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyImagePreview() {
    MyOldComposeTheme {
//        MyImage()
//        MyImageAdvance()
        MyIcon()
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.cat),
        contentDescription = "Imagen de un gato",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvance() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyVerticalSpacer(height = 16)

        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(60f)),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Imagen de un gato",
        )

        MyVerticalSpacer(height = 16)

        Image(
            modifier = Modifier
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Imagen de un gato",
        )

        MyVerticalSpacer(height = 16)

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Blue),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Imagen de un gato",
        )

        MyVerticalSpacer(height = 16)

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Blue, CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Imagen de un gato",
        )
    }
}

@Composable
fun MyIcon() {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (redStar, blueStar, greenStar, magentaStar, blackPerson) = createRefs()

        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Icono de una estrella",
            tint = Color.Red,
            modifier = Modifier.constrainAs(redStar) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(blueStar.start)
            }
        )

        Icon(
            imageVector = Icons.Sharp.Star,
            contentDescription = "Icono de una estrella",
            tint = Color.Blue,
            modifier = Modifier.constrainAs(blueStar) {
                start.linkTo(redStar.end)
                top.linkTo(redStar.bottom)
            }
        )

        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = "Icono de una estrella",
            tint = Color.Green,
            modifier = Modifier
                .border(2.dp, Color.Black)
                .constrainAs(greenStar) {
                start.linkTo(blueStar.end)
                top.linkTo(blueStar.bottom)
            }
        )

        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Icono de una estrella",
            tint = Color.Magenta,
            modifier = Modifier.constrainAs(magentaStar) {
                start.linkTo(greenStar.end)
                top.linkTo(greenStar.bottom)
            }
        )

        Icon(
            painter = painterResource(R.drawable.ic_personita),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.constrainAs(blackPerson) {
                start.linkTo(magentaStar.end)
                top.linkTo(greenStar.bottom)
            }
        )

    }

}