package com.github.ata.usecase.retrieve.dto

import com.github.ata.entity.ticket.Ticket

sealed class RetrieveTicketOutput {

    data class RetrieveTicketSuccess(val ticket: Ticket) : RetrieveTicketOutput()

    data class RetrieveTicketError(val message: String) : RetrieveTicketOutput()

}
