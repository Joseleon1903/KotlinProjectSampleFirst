package org.example.project.sample.first.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class SecondScreen : Screen {

    @Composable
    override fun Content() {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            Text("Welcome Second Screen.", fontSize = 26.sp, color = Color.White)

        }



    }
}