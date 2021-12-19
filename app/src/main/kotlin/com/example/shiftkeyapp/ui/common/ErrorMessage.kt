package com.example.shiftkeyapp.ui.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun ErrorMessage(
    message: String
) {
    Text(
        text = "ERROR OCCURRED: $message",
        textAlign = TextAlign.Center,
        color = Color.Red,
        fontSize = 30.sp
    )
}
