import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication
import ui.ChatAppWithScaffold

fun main() {
    NSApplication.sharedApplication()
    Window("Chat App") {
        ChatAppWithScaffold()
    }
    NSApp?.run()
}
