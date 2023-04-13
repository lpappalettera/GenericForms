import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow


fun main() {
    application {
        PreComposeWindow(
            title = "GenericForms",
            onCloseRequest = {
                exitApplication()
            },
        ) {
            MainView()
        }
    }
}