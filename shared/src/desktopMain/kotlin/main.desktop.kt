import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import ui.ChatAppWithScaffold

@Composable
fun MainView() = ChatAppWithScaffold()

@Preview
@Composable
fun ChatPreview() {
    MainView()
}
