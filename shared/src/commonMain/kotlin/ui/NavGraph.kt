package ui

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
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
                navigateToChat = {
                    navigator.navigate("/chat")
                },
            )
        }
        scene("/chat") { backStackEntry ->
           ChatScreen(navigateToNextScreen = {
               navigator.navigate("/nextScreen")
           })
        }
        scene("/nextScreen") { backStackEntry ->
            NextScreen()
        }
    }
}