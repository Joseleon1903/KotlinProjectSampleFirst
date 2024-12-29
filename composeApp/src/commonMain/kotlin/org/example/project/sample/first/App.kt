package org.example.project.sample.first

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.project.sample.first.screen.PreviewSplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        Navigator( screen = PreviewSplashScreen()){navigator: Navigator ->
            SlideTransition(navigator)

        }

    }
}

