package org.jetbrains.chat

import android.os.Bundle
import MainView
import moe.tlaster.precompose.lifecycle.setContent
import moe.tlaster.precompose.lifecycle.PreComposeActivity

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}
