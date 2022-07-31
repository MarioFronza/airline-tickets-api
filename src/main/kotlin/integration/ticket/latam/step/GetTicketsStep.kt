package integration.ticket.latam.step

import integration.http.ConnectionHttpClient
import integration.http.dto.StepResponse
import integration.ticket.latam.dto.Constants.BASE_SERVICE_URL
import integration.ticket.latam.dto.LatamTicketRequest

class GetTicketsStep(
    private val httpClient: ConnectionHttpClient
) {

    fun doRequest(request: LatamTicketRequest, cookies: String): StepResponse {
        val queryParams = """
            sort=PRICE%2Casc
            &cabinType=Economy
            &origin=${request.origin}
            &destination=${request.destination}
            &inFlightDate=null
            &inFrom=null
            &inOfferId=null
            &outFlightDate=null
            &outFrom=${request.outFrom} 
            &outOfferId=null
            &adult=1
            &child=0
            &infant=0
            &redemption=false
        """.trimIndent()

        val headers = mapOf(
            "x-latam-app-session-id" to "1",
            "content-type" to "application/json",
            "x-latam-action-name" to ":search-result.flightselection.offers-search",
            "x-latam-application-name" to ":web-air-offers",
            "x-latam-client-name" to ":web-air-offers",
            "x-latam-track-id" to "1",
            "x-latam-request-id" to "1",
            "x-latam-application-country" to "BR",
            "x-latam-application-oc" to "br",
            "x-latam-application-lang" to "pt",
            "sec-fetch-dest" to "empty",
            "sec-fetch-mode" to "cors",
            "sec-fetch-site" to "same-origin",
            "te" to "trailers",
            "cookie" to cookies
        )

        return httpClient.get(
            url = BASE_SERVICE_URL + ENDPOINT + queryParams,
            headers = headers
        ).toStepResponse()
    }

    companion object {
        const val ENDPOINT = "bff/air-offers/offers/search?"
    }

}