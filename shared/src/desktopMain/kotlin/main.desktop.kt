import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import ui.GenericFormsApp

@Composable
fun MainView() = GenericFormsApp()

@Preview
@Composable
fun ChatPreview() {
    MainView()
}
