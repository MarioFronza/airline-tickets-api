package integration.ticket.latam.dto

data class LatamTicketResponse(
    val content: List<Content>
)

data class Content(
    val summary: Summary
)

data class Summary(
    val origin: Origin,
    val destination: Destination,
    val lowestPrice: LowestPrice
)

data class Origin(
    val departure: String,
    val iataCode: String
)

data class Destination(
    val departure: String,
    val iataCode: String
)

data class LowestPrice(
    val amount: Double
)