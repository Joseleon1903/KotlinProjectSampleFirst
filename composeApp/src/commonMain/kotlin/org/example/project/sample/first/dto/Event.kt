package org.example.project.sample.first.dto

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable


@Serializable
data class Event (
    val name: String,
    val eventDate: LocalDate,
    val description: String?,
    val dayRemain: Int,
    val priority: String,
    val recurrence: String,
)


            





