import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication
import ui.GenericFormsApp

fun main() {
    NSApplication.sharedApplication()
    Window("Chat App") {
        GenericFormsApp()
    }
    NSApp?.run()
}
