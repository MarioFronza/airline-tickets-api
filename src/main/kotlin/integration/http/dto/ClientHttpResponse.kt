package integration.http.dto

data class ClientHttpResponse(
    val statusCode: Int,
    val body: String?,
    val headers: Map<String, List<String>>
)
