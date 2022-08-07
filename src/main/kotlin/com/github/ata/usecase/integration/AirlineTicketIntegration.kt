package com.github.ata.usecase.integration

import com.github.ata.usecase.integration.dto.AirlineTicketIntegrationInput
import com.github.ata.usecase.integration.dto.IntegrationOutput

interface AirlineTicketIntegration {

    fun integrate(input: AirlineTicketIntegrationInput): IntegrationOutput

}