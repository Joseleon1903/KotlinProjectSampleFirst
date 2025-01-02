package org.example.project.sample.first.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll

class MainScreen : Screen {



    @Composable
    override fun Content() {

        val scrollState = rememberScrollState()



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
                        text = "APERTURA DE PIERNAS",
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
                        NivelButton("Principiante", isSelected = true)
                        NivelButton("Intermedio", isSelected = false)
                        NivelButton("Avanzado", isSelected = false)
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
                        for (day in 1..5) {
                            DiaCard(dia = day, porcentaje = 0)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                }

            }



        }
}

@Composable
fun NivelButton(text: String, isSelected: Boolean) {
    Button(
        onClick = { /* Acción para cambiar de nivel */ },
        colors = ButtonDefaults.buttonColors(
            contentColor =if (isSelected) Color.Green else Color.Gray
        ),
//        modifier = Modifier.weight(1f)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.Black else Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun DiaCard(dia: Int, porcentaje: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$dia ° Día",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

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