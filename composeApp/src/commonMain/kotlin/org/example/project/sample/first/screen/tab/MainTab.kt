package org.example.project.sample.first.screen.tab

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.example.project.sample.first.screen.MainScreen
import org.example.project.sample.first.screen.event.AddEventScreen

object MainTab: Tab {



    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            return remember {
                TabOptions( index = 0u, title = "MainScreen", icon =icon )
            }
        }

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        MainScreen().Content();
    }



}