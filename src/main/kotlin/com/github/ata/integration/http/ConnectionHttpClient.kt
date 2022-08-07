package com.github.ata.integration.http

import com.github.ata.integration.http.dto.ClientHttpResponse

interface ConnectionHttpClient {

    fun get(url: String, headers: Map<String, String> = emptyMap()): ClientHttpResponse

}