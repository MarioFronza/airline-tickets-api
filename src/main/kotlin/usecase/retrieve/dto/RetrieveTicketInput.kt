package usecase.retrieve.dto

import usecase.integration.dto.AirlineTicketIntegrationInput

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