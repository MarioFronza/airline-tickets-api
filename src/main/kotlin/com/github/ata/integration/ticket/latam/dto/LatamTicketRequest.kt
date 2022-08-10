package com.github.ata.integration.ticket.latam.dto

import com.github.ata.shared.extension.StringExtensions.revertDate
import com.github.ata.usecase.integration.dto.AirlineTicketIntegrationInput

class LatamTicketRequest(
    val origin: String,
    val destination: String,
    val outFrom: String
) {

    companion object {
        fun fromAirlineTicketInput(airlineTicketIntegrationInput: AirlineTicketIntegrationInput) = LatamTicketRequest(
            origin = airlineTicketIntegrationInput.origin,
            destination = airlineTicketIntegrationInput.destination,
            outFrom = airlineTicketIntegrationInput.date.revertDate(),
        )
    }

}