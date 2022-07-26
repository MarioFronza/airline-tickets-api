package utils

import entity.ticket.Airport
import entity.ticket.Company
import entity.ticket.Ticket
import usecase.integration.dto.AirlineTicketIntegrationInput
import usecase.integration.dto.AirlineTicketIntegrationOutput
import usecase.retrieve.dto.RetrieveTicketInput

object ModelBuilder {

    fun createTicket(
        companyName: String = "Company",
        airportOrigin: String = "FLN",
        airportDestination: String = "GRU",
        date: String = "10-07-2022",
        price: Double = 100.0
    ) = Ticket(
        company = Company(companyName),
        origin = Airport(airportOrigin),
        destination = Airport(airportDestination),
        date = date,
        price = price
    )

    fun createAirlineTicketIntegrationInput(
        origin: String = "FLN",
        destination: String = "GRU",
        date: String = "10-07-2022"
    ) = AirlineTicketIntegrationInput(
        origin = origin,
        destination = destination,
        date = date
    )

    fun createRetrieveTicketInput(
        origin: String = "FLN",
        destination: String = "GRU",
        date: String = "10-07-2022"
    ) = RetrieveTicketInput(
        origin = origin,
        destination = destination,
        date = date
    )

    fun createAirlineTicketIntegrationOutput(
        companyName: String = "Company",
        lowestPrice: Double = 100.0,
        departureDate: String = "10-07-2022",
        airportOrigin: String = "FLN",
        airportDestination: String = "GRU"
    ) = AirlineTicketIntegrationOutput(
        companyName = companyName,
        lowestPrice = lowestPrice,
        departureDate = departureDate,
        airportOrigin = airportOrigin,
        airportDestination = airportDestination
    )


}