package com.github.ata.usecase.retrieve.dto

import com.github.ata.usecase.integration.dto.AirlineTicketIntegrationInput
import kotlinx.serialization.Serializable

@Serializable
data class RetrieveTicketInput(
    val origin: String,
    val destination: String,
    val date: String
) {
    fun toAirlineTicketInput() = AirlineTicketIntegrationInput(
        origin = origin,
        destination = destination,
        date = date
    )
}