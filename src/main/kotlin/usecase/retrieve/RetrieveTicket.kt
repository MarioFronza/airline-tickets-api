package usecase.retrieve

import entity.ticket.Ticket
import usecase.integration.AirlineTicketIntegration
import usecase.integration.dto.IntegrationOutput
import usecase.integration.dto.IntegrationOutput.IntegrationSuccess
import usecase.retrieve.dto.RetrieveTicketInput
import usecase.retrieve.dto.RetrieveTicketOutput
import usecase.retrieve.dto.RetrieveTicketOutput.RetrieveTicketSuccess
import usecase.retrieve.dto.RetrieveTicketOutput.RetrieveTicketError

class RetrieveTicket(
    private val integrations: List<AirlineTicketIntegration>
) {

    fun retrieve(input: RetrieveTicketInput): RetrieveTicketOutput {
        val integrationsResponse = integrations.map { integration ->
            integration.integrate(input.toAirlineTicketInput())
        }
        val tickets = getSuccessIntegrations(integrationsResponse)
        val lowestTicketPrice = tickets.minByOrNull { it.price }
        return createOutput(input, lowestTicketPrice)
    }

    private fun getSuccessIntegrations(integrationsResponse: List<IntegrationOutput>): List<Ticket> {
        return integrationsResponse
            .asSequence()
            .filterIsInstance<IntegrationSuccess>()
            .map { it.data.toEntity() }
            .toList()
    }

    private fun createOutput(input: RetrieveTicketInput, lowestTicketPrice: Ticket?): RetrieveTicketOutput {
        if (lowestTicketPrice == null) {
            return RetrieveTicketError(
                message = "Could not extract tickets for ${input.origin} to ${input.destination}"
            )
        }
        return RetrieveTicketSuccess(
            ticket = lowestTicketPrice
        )
    }
}