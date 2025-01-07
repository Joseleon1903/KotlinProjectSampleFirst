package org.example.project.sample.first

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.kodein.rememberNavigatorScreenModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.project.sample.first.screen.PreviewSplashScreen
import org.example.project.sample.first.screen.event.AddEventScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


val tabs = listOf(
    PreviewSplashScreen(), // Primera pestaña
    AddEventScreen() // Segunda pestaña, si tienes más
)

@Composable
@Preview
fun App() {
    MaterialTheme {

        Navigator( screen = PreviewSplashScreen(), ){navigator: Navigator ->
            SlideTransition(navigator)

        }

    }
}

