package usecase.retrieve.dto

import entity.ticket.Ticket

sealed class RetrieveTicketOutput {

    data class RetrieveTicketSuccess(val ticket: Ticket) : RetrieveTicketOutput()

    data class RetrieveTicketError(val message: String) : RetrieveTicketOutput()

}
