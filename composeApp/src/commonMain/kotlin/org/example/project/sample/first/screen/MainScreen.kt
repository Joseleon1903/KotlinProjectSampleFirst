package org.example.project.sample.first.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.russhwolf.settings.Settings
import org.example.project.sample.first.dto.Event
import org.example.project.sample.first.screen.SecondScreen.Companion.EVENT_STORE
import org.example.project.sample.first.util.DatoUtils

class MainScreen : Screen {


    private val setting : Settings = Settings();


    @Composable
    override fun Content() {

        val scrollState = rememberScrollState()

        val navigator = LocalNavigator.currentOrThrow
        val event = setting.getStringOrNull(EVENT_STORE)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all =16.dp )
            ) {

                // Encabezado
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(0xFF003366), shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Tareas",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Box( modifier = Modifier
                    .fillMaxWidth(),
//                    .height(200.dp),
                    contentAlignment = Alignment.Center){

                    // Selector de nivel
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        NivelButton("New Event", navigator)
                        NivelButton("Intermedio", navigator)
                        NivelButton("Avanzado", navigator)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(modifier = Modifier
                    .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    // Lista de días
                    Column(  modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Lista de días
                        println("event $event")
                        if (event != null) {
                            val events = DatoUtils().convertJsonStringToObjectArray(event)

                            for (ev in events) {
                                DiaCard(event = ev, porcentaje = 0)
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }

                }

            }



        }
}

@Composable
fun NivelButton(text: String, navegador : Navigator) {
    Button(
        onClick = {
            println("clien button")
        },
        colors = ButtonDefaults.buttonColors(
            contentColor =Color(0xFF01d89d)
        ),
//        modifier = Modifier.weight(1f)
    ) {
        Text(

            text = text,
            color =  Color.Black,
            fontSize = 14.sp
        )
    }
}

@Composable
fun DiaCard(event: Event, porcentaje: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = event.name,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = event.eventDate.toString(),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "remaning ${event.dayRemain} days",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFFF99CC), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$porcentaje%",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun NavItem(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
}