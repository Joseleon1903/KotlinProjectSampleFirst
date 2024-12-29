package org.example.project.sample.first

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProjectSampleFirst",
    ) {
        window.setSize(2340 , 1080)
//        rememberWindowState(width = 800.dp, height = 600.dp)
        App()
    }
}