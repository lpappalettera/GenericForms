package ui.chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import model.Message
import model.User
import ui.components.ChevronLeftIconButton
import utils.timestampMs

val friends = listOf(User("Alex"), User("Lily"), User("Sam"))
val friendMessages = listOf(
    "Hi, have a nice day!",
    "Nice to see you!",
    "Multiline\ntext\nmessage"
)
val store = CoroutineScope(SupervisorJob()).createStore()

@Composable
fun ChatScreen(
    user: User,
    navigateUp: () -> Unit,
    displayTextField: Boolean = true,
    navigateToNextScreen: () -> Unit
) {
    val state by store.stateFlow.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chat sample") },
                backgroundColor = MaterialTheme.colors.background,
                navigationIcon = {
                    ChevronLeftIconButton(onClick = navigateUp)
                },
            )
        }) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(Modifier.weight(1f)) {
                        Messages(user, state.messages)
                    }
                    Button(onClick = {
                        store.send(
                            Action.ClearMessages(true)
                        )
                    }) {
                        Text(text = "Clear messages")
                    }

                    Button(onClick = navigateToNextScreen) {
                        Text(text = "Go to next Screen")
                    }
                    if (displayTextField) {
                        SendMessage { text ->
                            store.send(
                                Action.SendMessage(
                                    Message(user, timeMs = timestampMs(), text)
                                )
                            )
                        }
                    }
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        while (true) {
            store.send(
                Action.SendMessage(
                    message = Message(
                        user = friends.random(),
                        timeMs = timestampMs(),
                        text = friendMessages.random()
                    )
                )
            )
            delay(5000)
        }
    }
}
