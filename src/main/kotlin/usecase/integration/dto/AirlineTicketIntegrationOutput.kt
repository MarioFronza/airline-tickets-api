package usecase.integration.dto

import entity.ticket.Airport
import entity.ticket.Company
import entity.ticket.Ticket

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
