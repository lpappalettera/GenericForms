package ui.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StartScreen(
    navigateToChat: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chat sample") },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = navigateToChat,
            ) {
                Text(text = "Start chat")
            }
        }
    }
}