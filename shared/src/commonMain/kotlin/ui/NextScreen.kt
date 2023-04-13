package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.TextfieldRow

@Composable
fun NextScreen(
    navigateUp: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registreer") },
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
            TextfieldRow(placeholder = "Uw naam")
            Spacer(modifier = Modifier.height(20.dp))
            TextfieldRow(placeholder = "Uw adres")
            Spacer(modifier = Modifier.height(20.dp))
            TextfieldRow(placeholder = "Uw registatienummer")
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = navigateUp,
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight
                    )
            ) {
                Text(text = "Registreer")
            }
        }


    }
}
