package integration.ticket.latam.step

import integration.http.ConnectionHttpClient
import integration.http.dto.ClientHttpResponse
import integration.http.dto.StepResponse.StepSuccess
import integration.http.dto.StepResponse.StepError
import integration.ticket.latam.dto.Constants.BASE_SERVICE_URL
import integration.ticket.latam.dto.LatamTicketRequest
import io.mockk.every
import io.mockk.mockk
import java.net.HttpURLConnection
import kotlin.test.Test
import kotlin.test.assertEquals


class GetTicketsStepTest {

    private val httpClient: ConnectionHttpClient = mockk()
    private val step = GetTicketsStep(httpClient)

    @Test
    fun `should return StepSuccess when execute step successfully`() {
        val endpoint = "bff/air-offers/offers/search?"
        val headers = mapOf(
            "Set-Cookie" to listOf("Cookie 1", "Cookie 2")
        )

        every {
            httpClient.get(
                url = BASE_SERVICE_URL + endpoint + queryParams,
                headers = requestHeaders
            )
        } returns ClientHttpResponse(
            statusCode = HttpURLConnection.HTTP_OK,
            body = "SUCCESS RESPONSE",
            headers = headers
        )

        val expected = StepSuccess(payload = "SUCCESS RESPONSE", headers = headers)
        val actual = step.doRequest(
            request = LatamTicketRequest(
                origin = "origin",
                destination = "destination",
                outFrom = "01/01/2022"
            ),
            cookies = "cookies"
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `should return StepError when not execute step successfully`() {
        val endpoint = "bff/air-offers/offers/search?"
        val headers = mapOf(
            "Set-Cookie" to listOf("Cookie 1", "Cookie 2")
        )

        every {
            httpClient.get(
                url = BASE_SERVICE_URL + endpoint + queryParams,
                headers = requestHeaders
            )
        } returns ClientHttpResponse(
            statusCode = HttpURLConnection.HTTP_BAD_REQUEST,
            body = "ERROR RESPONSE",
            headers = headers
        )

        val expected = StepError(payload = "ERROR RESPONSE")
        val actual = step.doRequest(
            request = LatamTicketRequest(
                origin = "origin",
                destination = "destination",
                outFrom = "01/01/2022"
            ),
            cookies = "cookies"
        )

        assertEquals(expected, actual)
    }

    companion object {
        const val queryParams = "sort=PRICE%2Casc" +
                "&cabinType=Economy" +
                "&origin=origin" +
                "&destination=destination" +
                "&inFlightDate=null" +
                "&inFrom=null" +
                "&inOfferId=null" +
                "&outFlightDate=null" +
                "&outFrom=01/01/2022" +
                "&outOfferId=null" +
                "&adult=1" +
                "&child=0" +
                "&infant=0" +
                "&redemption=false"

        val requestHeaders = mapOf(
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
            "cookie" to "cookies"
        )
    }

}