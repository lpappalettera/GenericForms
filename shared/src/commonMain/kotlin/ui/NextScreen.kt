package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.TextfieldRow

@Composable
fun NextScreen(
) {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextfieldRow(placeholder = "Uw naam")
                TextfieldRow(placeholder = "Uw adres")
                TextfieldRow(placeholder = "Uw registatienummer")
            }
        }
    }
}
