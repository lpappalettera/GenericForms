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

val friends = listOf(User("Ivo"), User("Luciano"), User("Marloes"), User("Robert"), User("Andre"))
val friendMessages = listOf(
    "Hey, hallo daar!",
    "Hey leuke app!",
    "Deze app is beschikbaar op:\n- Android\n- iOS\n- Desktop\nen je webbrowser!",
    "Te veel spam...",
    "UI van deze app is echt mooi",
    "Hallo hoe werkt dit?",
    "Vergeet niet je uren te schrijven he",
    "Toffe presentatie",
    "Ik heb 39 Apple producten",
    "Waar zijn de snacks?",
    "Wie wil er koffie?",
    "Wow team paars heeft echt een coole app gebouwd"
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
                title = { Text("Team Paars Chat") },
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
