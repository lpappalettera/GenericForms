package ui.start

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.ui.viewModel

@Composable
fun StartScreen(
    navigateToChat: (String) -> Unit
) {
    val viewModel = viewModel(StartViewModel::class) { StartViewModel() }
    val state = viewModel.viewState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beste app") },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                label = { Text(text = "Username") },
                value = state.username,
                onValueChange = { viewModel.onUsernameChanged(it) }
            )

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Password") },
                value = state.password,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { viewModel.onPasswordChanged(it) }
            )

            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = { navigateToChat(state.username) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight
                    )
            ) {
                Text(text = "Login")
            }

        }
    }
}