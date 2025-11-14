package com.example.mynewcompose.presentation.components.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

@Preview(showSystemUi = true)
@Composable
fun MyProgressAdvanceParentPreview() {
    Scaffold { innerPadding ->
        MyParentProgress(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentProgressAdvance(modifier: Modifier) {
    var progress: Float by remember { mutableFloatStateOf(0.5f) }
    var isLoading: Boolean by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(targetValue = progress)
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .paddingFromBaseline(Dimens.columnPaddingFromBaseline),
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.width(24.dp))
        if (isLoading) {
            MyAdvanceCircularProgressIndicator(animatedProgress)
            MyAdvanceLinearProgressIndicator(animatedProgress)

            MyProgressButtons(
                onAdd = { progress = addProgress(progress) },
                onSubtract = { progress = subtractProgress(progress) },
            )
        }
        MyProgressButton(
            onClick = { isLoading = !isLoading },
            text = if (isLoading) stringResource(R.string.hint_hide) else stringResource(R.string.hint_show),
        )
    }
}

@Composable
fun MyAdvanceCircularProgressIndicator(progress: Float) {
    CircularProgressIndicator(
        progress = { progress },
        modifier = Modifier.size(100.dp),
        color = Color.Magenta,
        strokeWidth = 10.dp,
        trackColor = Color.LightGray,
        strokeCap = StrokeCap.Square,
    )
}

@Composable
fun MyAdvanceLinearProgressIndicator(progress: Float) {
    LinearProgressIndicator(
        progress = { progress },
        modifier =
            Modifier
                .width(350.dp)
                .height(10.dp),
        color = Color.Magenta,
        trackColor = Color.LightGray,
        strokeCap = StrokeCap.Round,
    )
}

@Composable
fun MyProgressButtons(
    onAdd: () -> Unit,
    onSubtract: () -> Unit,
) {
    Row(Modifier.padding(24.dp)) {
        MyProgressButton(
            onClick = { onSubtract() },
            text = "<<",
        )
        Spacer(Modifier.width(24.dp))
        MyProgressButton(
            onClick = { onAdd() },
            text = ">>",
        )
    }
}

@Composable
fun MyProgressButton(
    onClick: () -> Unit,
    text: String,
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}

fun addProgress(progress: Float): Float = progress + 0.1f

fun subtractProgress(progress: Float): Float = progress - 0.1f
