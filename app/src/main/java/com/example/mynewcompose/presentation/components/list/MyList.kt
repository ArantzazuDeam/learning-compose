package com.example.mynewcompose.presentation.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.ui.theme.Pink100
import com.example.mynewcompose.ui.theme.Pink40

@Composable
fun MyBasicList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(friendList) { item ->
            Text(
                modifier =
                    Modifier
                        .fillParentMaxWidth()
                        .padding(12.dp)
                        .background(Pink100),
                text = item,
            )
        }
    }
}

@Composable
fun MyBasicHorizontalList(
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit,
) {
    LazyRow(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(friendList) { item ->
            Text(
                modifier =
                    Modifier
                        .padding(12.dp)
                        .background(Pink100)
                        .clickable { onItemClick(item) },
                text = item,
                textAlign = TextAlign.Center,
                color = Pink40,
            )
        }
    }
}
