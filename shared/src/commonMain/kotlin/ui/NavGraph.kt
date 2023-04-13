package ui

import androidx.compose.runtime.Composable
import model.User
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import ui.chat.ChatScreen
import ui.start.StartScreen

@Composable
fun NavGraph() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        initialRoute = "/start"
    ) {
        scene("/start") {
            StartScreen (
                navigateToChat = { username ->
                    navigator.navigate("/chat/$username")
                },
            )
        }
        scene("/chat/{username}") { backStackEntry ->
            backStackEntry.path<String>("username")?.let { username ->
                ChatScreen(
                    user = User(username),
                    navigateUp = navigator::goBack
                )
            }
        }
    }
}