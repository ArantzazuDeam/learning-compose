package com.example.mynewcompose.presentation.components.progress

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mynewcompose.R

//@Preview(showSystemUi = true)
@Composable
fun MyLottieProgressParentPreview() {
    Scaffold { innerPadding ->
        MyParentLottieProgress(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentLottieProgress(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        MyLottieAnimationProgressIndicator()
    }
}

@Composable
fun MyLottieAnimationProgressIndicator() {
    val hourglassLoadingComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hourglass_loading))
    LottieAnimation(
        composition = hourglassLoadingComposition,
        iterations = LottieConstants.IterateForever,
    )
}
