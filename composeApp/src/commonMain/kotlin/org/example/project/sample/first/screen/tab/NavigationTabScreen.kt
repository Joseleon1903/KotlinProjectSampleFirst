package org.example.project.sample.first.screen.tab

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.example.project.sample.first.screen.event.AddEventScreen

class NavigationTabScreen : Screen{

    @Composable
    override fun Content() {

        TabNavigator(
            MainTab,
            tabDisposable ={
                TabDisposable(it,
                    listOf(MainTab, SecondTab, SettingTab)
                )
            }
        ){
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(it.current.options.title) })
                },
                bottomBar = {
                    BottomNavigation {
                        val tabNavigator = LocalTabNavigator.current

                        BottomNavigationItem(
                            selected = tabNavigator.current.key == MainTab.key,
                            label = { Text(MainTab.options.title) },
                            icon = {
                                Icon(
                                    painter = MainTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = { tabNavigator.current = MainTab }
                        )


                        BottomNavigationItem(
                            selected = tabNavigator.current.key == SecondTab.key,
                            label = { Text(SecondTab.options.title) },
                            icon = {
                                Icon(
                                    painter = SecondTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = { tabNavigator.current = SecondTab }
                        )


                        BottomNavigationItem(
                            selected = tabNavigator.current.key == SettingTab.key,
                            label = { Text(SettingTab.options.title) },
                            icon = {
                                Icon(
                                    painter = SettingTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = { tabNavigator.current = SettingTab }
                        )

                    }
                },
                content = { CurrentTab() }
            )

        }

    }
}





//        val navigator = LocalNavigator.currentOrThrow;
//
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//
//            Button( onClick = {
//                println("Got to screen name : MainScreen")
//                navigator.push(MainScreen())
//            }){
//                Text(text = "Go to Screen", fontSize = 24.sp)
//            }
//
//            Spacer( modifier = Modifier.height(18.dp))
//
//            Button( onClick = {
//                println("Got to screen name : SecondScreen")
//                navigator.push(SecondScreen())
//            }){
//                Text(text = "Go to Screen", fontSize = 24.sp)
//            }
//
//            Spacer( modifier = Modifier.height(18.dp))
//
//            Button( onClick = {
//                println("Got to screen name : Setting")
//                navigator.push(SettingScreen())
//            }){
//                Text(text = "Go to Screen", fontSize = 24.sp)
//            }
//        }