package integration.ticket.latam.extractor

import integration.http.okhttp.ConnectionOkHttpClient
import integration.ticket.latam.dto.LatamTicketRequest
import integration.ticket.latam.dto.LatamTicketResponse

class LatamTicketExtractor(
    val client: ConnectionOkHttpClient = ConnectionOkHttpClient()
) {

    fun extract(request: LatamTicketRequest): LatamTicketResponse {
        client.get("")
    }

}