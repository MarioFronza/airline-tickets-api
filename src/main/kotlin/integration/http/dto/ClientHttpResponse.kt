package integration.http.dto

data class ClientHttpResponse(
    val statusCode: Int,
    val body: String?,
    val headers: Map<String, List<String>>
) {

    fun toStepResponse() = with(this) {
        val body = getNotNullBody()
        if (statusCode == 200) {
            StepResponse.StepSuccess(payload = body, headers = headers)
        } else {
            StepResponse.StepError(payload = body)
        }

    }

    private fun getNotNullBody() = body ?: throw Exception("Response with null body")

}