package integration.http.dto

sealed class StepResponse {

    data class StepSuccess(val payload: String, val headers: Map<String, List<String>>): StepResponse(){

        fun getHeaderByKey(key: String): String {
            return headers[key]?.joinToString()
                ?: throw IllegalArgumentException("Header with key: $key does not exists")
        }

    }

    data class StepError(val payload: String): StepResponse()

}