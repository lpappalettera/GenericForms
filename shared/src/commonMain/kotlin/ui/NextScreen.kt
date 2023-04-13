package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.components.TextfieldRow

@Composable
fun NextScreen(
) {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextfieldRow(title = "Naam", placeholder = "Uw naam")
                TextfieldRow(title = "Adres", placeholder = "Uw adres")
                TextfieldRow(title = "Registratienummer", placeholder = "Uw registatienummer")
            }
        }
    }
}
