package ui

import androidx.compose.runtime.Composable
import model.User
import theme.GenericFormsTheme
import ui.chat.ChatScreen

@Composable
fun GenericFormsApp() {
    GenericFormsTheme {
        NavGraph()
    }
}

@Composable
fun ChatApp() {
    GenericFormsTheme {
        ChatScreen(user = User("Me"), navigateUp = {}, navigateToNextScreen = {})
    }
}



