package com.github.ata.integration.ticket.latam.step

import com.github.ata.integration.http.ConnectionHttpClient
import com.github.ata.integration.http.dto.StepResponse
import com.github.ata.integration.ticket.latam.dto.Constants.BASE_SERVICE_URL

class GetCookiesStep(
    private val httpClient: ConnectionHttpClient
) {

    fun doRequest(): StepResponse {
        return httpClient.get(BASE_SERVICE_URL).toStepResponse()
    }

}