package org.example.project.sample.first.util

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromJsonElement
import org.example.project.sample.first.dto.Event

class DatoUtils {

    fun convertObjectToJsonString(event: Event): String {
        return Json.encodeToString(event)
    }

    fun convertObjectArrayToJsonString(events: Array<Event>?): String {
        return Json.encodeToString(events)
    }

    fun convertJsonStringToObject(event: String): Event {
        return Json.decodeFromString(event)
    }

    fun convertJsonStringToObjectArray(event: String?): Array<Event> {
        if(event == null){
            return arrayOf();
        }
        return Json.decodeFromString(event)
    }

}