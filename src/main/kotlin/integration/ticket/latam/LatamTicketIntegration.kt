package integration.ticket.latam

import usecase.integration.AirlineTicketIntegration
import usecase.integration.dto.AirlineTicketIntegrationInput
import usecase.integration.dto.AirlineTicketIntegrationOutput
import usecase.integration.dto.IntegrationOutput

class LatamTicketIntegration : AirlineTicketIntegration {

    override fun integrate(input: AirlineTicketIntegrationInput): IntegrationOutput {
        return IntegrationOutput.IntegrationSuccess(
            data = AirlineTicketIntegrationOutput(
                companyName = "companyName",
                departureDate = "",
                lowestPrice = 10.0,
                airportOrigin = "",
                airportDestination = ""
            )
        )
    }

}