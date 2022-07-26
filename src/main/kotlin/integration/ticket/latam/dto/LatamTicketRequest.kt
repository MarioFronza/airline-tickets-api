package integration.ticket.latam.dto

import usecase.integration.dto.AirlineTicketIntegrationInput

class LatamTicketRequest(
    val origin: String,
    val destination: String,
    val date: String
) {

    companion object {
        fun fromAirlineTicketInput(airlineTicketIntegrationInput: AirlineTicketIntegrationInput) = LatamTicketRequest(
            origin = airlineTicketIntegrationInput.origin,
            destination = airlineTicketIntegrationInput.destination,
            date = airlineTicketIntegrationInput.date,
        )
    }

}