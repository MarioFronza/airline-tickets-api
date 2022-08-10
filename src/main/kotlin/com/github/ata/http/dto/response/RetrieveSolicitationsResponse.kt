package com.github.ata.http.dto.response

import com.github.ata.entity.ticket.Ticket
import com.github.ata.usecase.solicitation.dto.SolicitationOutput
import com.github.ata.usecase.solicitation.dto.Summary
import kotlinx.serialization.Serializable


@Serializable
data class RetrieveSolicitationsResponse(
    val cheapestTickets: List<TicketResponse>,
    val summary: SummaryResponse
) {
    companion object {
        fun fromSolicitationOutput(output: SolicitationOutput) = RetrieveSolicitationsResponse(
            cheapestTickets = output.cheapestTickets.map { ticket ->
                TicketResponse.fromTicket(ticket)
            },
            summary = SummaryResponse.fromSummary(output.summary)
        )
    }
}

@Serializable
data class TicketResponse(
    val company: String,
    val origin: String,
    val destination: String,
    val date: String,
    val price: Double
) {
    companion object {
        fun fromTicket(ticket: Ticket) = TicketResponse(
            company = ticket.company.name,
            origin = ticket.origin.name,
            destination = ticket.destination.name,
            date = ticket.date,
            price = ticket.price
        )
    }
}

@Serializable
data class SummaryResponse(
    val error: List<String>
) {
    companion object {
        fun fromSummary(summary: Summary) = SummaryResponse(
            error = summary.error
        )
    }
}