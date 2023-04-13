package ui.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TextfieldRow(
    placeholder: String,
){
    var input by remember { mutableStateOf("") }

    TextField(
        label = { Text(text = placeholder) },
        value = input,
        onValueChange = { input = it }
    )
}