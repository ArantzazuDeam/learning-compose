package com.example.mynewcompose.presentation.components.imageAndIcon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

const val IMG_URL_CAT =
    "https://hips.hearstapps.com/hmg-prod/images/ginger-maine-coon-kitten-running-on-lawn-in-royalty-free-image-1719608142.jpg?crop=1xw:0.84415xh;0,0.185xh"

@Preview(showSystemUi = true)
@Composable
fun MyImageParentPreview() {
    Scaffold { innerPadding ->
        MyParentImage(Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentImage(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .verticalScroll(rememberScrollState())
                .paddingFromBaseline(Dimens.columnPaddingFromBaseline),
        verticalArrangement = Arrangement.spacedBy(Dimens.columnVerticalSpacing),
    ) {
        MyNetworkImage()
        MyFirstImage()
        MyFirstRoundedImage()
        MyPercentageRoundedImage()
        MyCircleImage()
        MyRectangleImage()
    }
}

@Composable
fun MyFirstImage() {
    Image(
        painter = painterResource(R.drawable.cat),
        contentDescription = "Imagen decorativa con gatos",
        modifier =
            Modifier
                .height(200.dp)
                .width(300.dp)
                .background(Color.Blue)
                .border(width = 16.dp, color = Color.Cyan),
        contentScale = ContentScale.Inside,
    )
}

@Composable
fun MyFirstRoundedImage() {
    Image(
        painter = painterResource(R.drawable.cat),
        contentDescription = stringResource(R.string.content_description_decor_cat),
        modifier =
            Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun MyPercentageRoundedImage() {
    Image(
        painter = painterResource(R.drawable.cat),
        contentDescription = stringResource(R.string.content_description_decor_cat),
        modifier =
            Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(40)),
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun MyCircleImage() {
    Image(
        painter = painterResource(R.drawable.cat),
        contentDescription = stringResource(R.string.content_description_decor_cat),
        modifier =
            Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    brush = linearGradient(colors = listOf(Color.Yellow, Color.Green, Color.Cyan, Color.Blue)),
                    shape = RoundedCornerShape(50),
                ),
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun MyRectangleImage() {
    Image(
        painter = painterResource(R.drawable.cat),
        contentDescription = stringResource(R.string.content_description_decor_cat),
        modifier =
            Modifier
                .size(200.dp)
                .clip(RectangleShape),
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun MyNetworkImage() {
    AsyncImage(
        model = IMG_URL_CAT,
        contentDescription = stringResource(R.string.content_description_decor_cat),
        contentScale = ContentScale.Fit,
        modifier =
            Modifier
                .size(200.dp)
                .background(
                    brush =
                        linearGradient(
                            colors = listOf(Color.Red, Color.Magenta, Color.Blue),
                        ),
                ),
    )
}
