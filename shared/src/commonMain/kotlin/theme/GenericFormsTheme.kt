package theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GenericFormsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(
            surface = Color(ChatColors.SURFACE),
            background = Color(ChatColors.BACKGROUND),
        ),
    ) {
        content()
    }
}