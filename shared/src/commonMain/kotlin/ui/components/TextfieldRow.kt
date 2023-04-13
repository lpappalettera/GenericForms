package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextfieldRow(
    title: String,
    placeholder: String,
){
    var input by remember { mutableStateOf("") }

    Column {
        Row(horizontalArrangement = Arrangement.Start){
            Text(text = "$title:")
        }
        Row(horizontalArrangement = Arrangement.Center)
        {

            TextField(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(10.dp),

                value = input,
                placeholder = {
                    Text(placeholder)
                },
                onValueChange = {
                    input = it
                }
            )
        }
    }
}