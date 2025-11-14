package com.example.mynewcompose.presentation.components.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

@Preview(showSystemUi = true)
@Composable
fun MyProgressParentPreview() {
    Scaffold { innerPadding ->
        MyParentProgress(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentProgress(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .paddingFromBaseline(Dimens.columnPaddingFromBaseline),
        verticalArrangement = Arrangement.spacedBy(Dimens.columnVerticalSpacing),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyFirstCircularProgressIndicator()
        MyLinearProgressIndicator()
    }
}

@Composable
fun MyFirstCircularProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.size(100.dp),
        color = Color.Magenta,
        strokeWidth = 10.dp,
        trackColor = Color.LightGray,
        strokeCap = StrokeCap.Round,
    )
}

@Composable
fun MyLinearProgressIndicator() {
    LinearProgressIndicator(
        modifier = Modifier
            .width(400.dp)
            .height(10.dp),
        color = Color.Magenta,
        trackColor = Color.LightGray,
        strokeCap = StrokeCap.Round,
    )
}
