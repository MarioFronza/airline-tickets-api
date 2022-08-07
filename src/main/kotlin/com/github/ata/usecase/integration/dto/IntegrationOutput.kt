package com.github.ata.usecase.integration.dto

sealed class IntegrationOutput {

    data class IntegrationSuccess(val data: AirlineTicketIntegrationOutput) : IntegrationOutput()

    data class IntegrationError(val message: String?) : IntegrationOutput()

}
