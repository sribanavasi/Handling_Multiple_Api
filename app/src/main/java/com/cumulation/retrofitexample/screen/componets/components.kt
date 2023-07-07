package com.cumulation.retrofitexample.screen.componets

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(text: String) {
    Text(
        modifier = Modifier.padding(bottom = 10.dp),
        text = text,
        style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun CircularLoader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun IndicatorWithErrorMessage(message: String?) {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = "Error Icon",
                tint = MaterialTheme.colors.error
            )
            Text(
                text = message ?: "",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.error
            )
        }
    }
}

@Composable
fun CardWithText(text: String?) {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Text(
            text = text ?: "",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp)
        )
    }
}