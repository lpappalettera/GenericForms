import androidx.compose.ui.window.ComposeUIViewController
import model.Message
import platform.UIKit.UIViewController
import theme.ChatColors
import ui.ChatApp
import ui.chat.Action
import ui.myUser
import ui.store
import utils.timestampMs

fun ChatViewController(): UIViewController = ComposeUIViewController {
    ChatApp(displayTextField = false)
}

fun sendMessage(text: String) {
    store.send(Action.SendMessage(Message(myUser, timestampMs(), text)))
}

fun gradient3Colors() = ChatColors.GRADIENT_3

fun surfaceColor() = ChatColors.SURFACE
