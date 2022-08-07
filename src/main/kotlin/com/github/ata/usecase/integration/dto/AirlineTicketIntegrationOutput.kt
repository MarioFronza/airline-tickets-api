package com.github.ata.usecase.integration.dto

import com.github.ata.entity.ticket.Airport
import com.github.ata.entity.ticket.Company
import com.github.ata.entity.ticket.Ticket

data class AirlineTicketIntegrationOutput(
    val companyName: String,
    val departureDate: String,
    val lowestPrice: Double,
    val airportOrigin: String,
    val airportDestination: String
) {
    fun toEntity() = Ticket(
        company = Company(companyName),
        origin = Airport(airportOrigin),
        destination = Airport(airportDestination),
        date = departureDate,
        price = lowestPrice
    )
}
