package usecase.integration

import usecase.integration.dto.AirlineTicketIntegrationInput
import usecase.integration.dto.IntegrationOutput

interface AirlineTicketIntegration {

    fun integrate(input: AirlineTicketIntegrationInput): IntegrationOutput

}