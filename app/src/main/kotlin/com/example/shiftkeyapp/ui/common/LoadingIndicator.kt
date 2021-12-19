package com.example.shiftkeyapp.ui.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = Color.Green,
        strokeWidth = 5.dp,
    )
}