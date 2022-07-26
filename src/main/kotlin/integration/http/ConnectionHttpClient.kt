package integration.http

import integration.http.dto.ClientHttpResponse

interface ConnectionHttpClient {

    fun get(url: String, headers: Map<String, String> = emptyMap()): ClientHttpResponse

}