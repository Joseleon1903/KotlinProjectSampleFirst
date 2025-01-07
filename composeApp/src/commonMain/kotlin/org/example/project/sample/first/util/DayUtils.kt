package org.example.project.sample.first.util

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime

class DayUtils {

    fun calculateDaysDifference(startDate: LocalDate, endDate: LocalDate): Int {
        return startDate.daysUntil(endDate)
    }

    fun getCurrentLocalDate(): LocalDate {
        // Obtener el instante actual desde el reloj del sistema
        val currentInstant = Clock.System.now()

        // Convertir el instante a LocalDate utilizando la zona horaria del sistema
        return currentInstant.toLocalDateTime(TimeZone.currentSystemDefault()).date
    }
}