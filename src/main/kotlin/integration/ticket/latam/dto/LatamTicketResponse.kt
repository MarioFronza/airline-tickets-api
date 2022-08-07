package integration.ticket.latam.dto

import kotlinx.serialization.Serializable

@Serializable
data class LatamTicketResponse(
    val content: List<Content>
)

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

