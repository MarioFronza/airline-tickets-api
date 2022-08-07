package com.github.ata.integration.ticket.latam

import com.github.ata.integration.ticket.latam.dto.LatamTicketRequest.Companion.fromAirlineTicketInput
import com.github.ata.integration.ticket.latam.extractor.LatamTicketExtractor
import com.github.ata.shared.extension.getLogger
import com.github.ata.usecase.integration.AirlineTicketIntegration
import com.github.ata.usecase.integration.dto.AirlineTicketIntegrationInput
import com.github.ata.usecase.integration.dto.IntegrationOutput
import com.github.ata.usecase.integration.dto.IntegrationOutput.IntegrationError
import com.github.ata.usecase.integration.dto.IntegrationOutput.IntegrationSuccess

class LatamTicketIntegration(
    private val latamTicketExtractor: LatamTicketExtractor
) : AirlineTicketIntegration {

    override fun integrate(input: AirlineTicketIntegrationInput): IntegrationOutput {
        return try {
            val extractorResponse = latamTicketExtractor.extract(
                request = fromAirlineTicketInput(input)
            )
            IntegrationSuccess(
                data = extractorResponse.toAirlineTicketOutput()
            )
        } catch (e: Exception) {
            logger.error(e.message)
            IntegrationError(
                message = e.message
            )
        }
    }

    companion object {
        val logger = getLogger()
    }


}