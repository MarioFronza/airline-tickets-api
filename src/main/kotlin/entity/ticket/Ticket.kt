package entity.ticket

data class Ticket(
    val company: Company,
    val origin: Airport,
    val destination: Airport,
    val date: String,
    val price: Double
)
