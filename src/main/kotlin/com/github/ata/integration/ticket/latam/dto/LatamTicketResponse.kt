package com.github.ata.integration.ticket.latam.dto

import com.github.ata.integration.ticket.latam.dto.Constants.COMPANY_NAME
import com.github.ata.shared.extension.StringExtensions.timestampToSimpleDate
import com.github.ata.usecase.integration.dto.AirlineTicketIntegrationOutput
import kotlinx.serialization.Serializable

@Serializable
data class LatamTicketResponse(
    val content: List<Content>
) {
    fun toAirlineTicketOutput() = content.first().let {
        AirlineTicketIntegrationOutput(
            companyName = COMPANY_NAME,
            lowestPrice = it.summary.lowestPrice.amount,
            departureDate = it.summary.origin.departure.timestampToSimpleDate(),
            airportOrigin = it.summary.origin.iataCode,
            airportDestination = it.summary.destination.iataCode
        )
    }
}

@Serializable
data class Content(
    val summary: Summary
)

@Serializable
data class Summary(
    val origin: Origin,
    val destination: Destination,
    val lowestPrice: LowestPrice
)

@Serializable
data class Origin(
    val departure: String,
    val iataCode: String
)

@Serializable
data class Destination(
    val iataCode: String
)

@Serializable
data class LowestPrice(
    val amount: Double
)

