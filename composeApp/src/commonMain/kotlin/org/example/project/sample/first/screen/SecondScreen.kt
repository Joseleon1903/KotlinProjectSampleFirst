package org.example.project.sample.first.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import org.example.project.sample.first.dto.Event
import org.example.project.sample.first.util.DayUtils
import kotlinx.datetime.LocalDate
import org.example.project.sample.first.util.DatoUtils

class SecondScreen : Screen {

    private val setting : Settings = Settings();

    private var eventArray: Array<Event>? = null;
    companion object{
        const val EVENT_STORE = "EVENT_STORE_V1"
    }

    fun setUpStorage(){
        println("entering setUpStorage")
        if(setting.getStringOrNull(EVENT_STORE) != null){
            println("existe data ")
            var dtrdata= setting.getStringOrNull(EVENT_STORE);
            println("dtrdata ; $dtrdata")
            eventArray = DatoUtils().convertJsonStringToObjectArray(setting.getStringOrNull(EVENT_STORE));
        }else{
            println("NO EXISTE DATA")
            eventArray = arrayOf();
        }
    }

    @Composable
    override fun Content() {

        var name by remember { mutableStateOf("") }
        var eventDate by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var priority by remember { mutableStateOf("") }

        val priorityOptions =listOf("Basic", "Medium", "High", "Essential")

        val options =listOf("None", "Daily", "Weekly", "Monthly")
        var selectedOption by remember { mutableIntStateOf(0) }
        var expanded by remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = eventDate,
                    onValueChange = { eventDate = it },
                    label = { Text("Event Date (yyyy-mm-dd)") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                SingleChoiceSegmentedButtonRow(
                    options = options,
                    selectedIndex = selectedOption,
                    onOptionSelected = { selectedOption = it }
                )

                Box(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.TopStart)) {
                    Button(onClick = { expanded = !expanded }) {
                        Text("Select")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        priorityOptions.forEach { option ->
                            DropdownMenuItem(onClick = {
                                priority = option
                                expanded = false
                            }) {
                                Text(text = option)
                            }
                        }
                    }
                }

                Button(
                    onClick = {
                        // Valida los datos y llama a la función onSave
                        val parsedDate = try {
                             LocalDate.parse(eventDate)
                        } catch (e: Exception) {
                            println(e.message)
                            null
                        }
                        if (name.isNotEmpty() && parsedDate != null) {
                            println("save data")
                            var today : LocalDate = DayUtils().getCurrentLocalDate()

                            onSave(
                                Event(
                                    name = name,
                                    eventDate = parsedDate,
                                    description = description.takeIf { it.isNotBlank() },
                                    dayRemain = DayUtils().calculateDaysDifference(today , parsedDate),
                                    priority = priority,
                                    recurrence =options[selectedOption]
                                )
                            )
                        } else {
                            // Maneja la validación (por ejemplo, muestra un error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Save")
                }
            }

        }



    }

    private fun onSave(event: Event) {
        println("entering in onSave")
        println("event  $event")

        setUpStorage();
        eventArray = eventArray?.plus(event)
        setting[EVENT_STORE] = DatoUtils().convertObjectArrayToJsonString(eventArray)
        println("Returning $eventArray")
    }
}

@Composable
fun SingleChoiceSegmentedButtonRow(
    options: List<String>, // Opciones del botón segmentado
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        options.forEachIndexed { index, option ->
            val isSelected = selectedIndex == index
            Button(
                onClick = { onOptionSelected(index) },
                modifier = Modifier
                    .weight(1f)
                    .padding(2.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isSelected) Color.Blue else Color.White,
                    contentColor = if (isSelected) Color.White else Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = option)
            }
        }
    }
}
