package org.example.project.sample.first.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import org.example.project.sample.first.screen.tab.NavigationTabScreen


class PreviewSplashScreen : Screen {

    private fun onLoadingComplete(navegador : Navigator) {
        println("GO to next Screen..")
        navegador.push(NavigationTabScreen())
    }

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        var progress by remember { mutableStateOf(0f) }
//        val painter = lazyPainterResource("composeResources/files/todoist_logo_icon.png")
        // Proceso de carga simulada
        LaunchedEffect(Unit) {
            while (progress < 1f) {
                delay(150) // Simula el tiempo de carga
                progress += 0.02f
            }
            // Acción al finalizar la carga
            onLoadingComplete(navigator)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0F1C44)), // Fondo azul oscuro
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Imagen del logo
//                painter.getOrNull()?.let {
//                    Image(
//                        painter = it, // Reemplaza con tu recurso real
//                        contentDescription = "Logo de App running++",
//                        modifier = Modifier.size(150.dp), // Ajusta el tamaño según sea necesario
//                        contentScale = ContentScale.Fit
//                    )
//                }
                Text(text = "Welcome to this Multiplatform application", fontSize = 36.sp)

                Spacer( modifier = Modifier.height(20.dp))
                // Barra de progreso
                LinearProgressIndicator(
                    progress = progress,
                    color = Color.White,
                    backgroundColor = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(8.dp)
                )

                // Texto opcional
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Cargando...",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

        }

    }




}