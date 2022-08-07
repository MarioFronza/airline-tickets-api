package com.github.ata.http.ktor.controller

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Location("/health")
class HealthCheck

fun Route.healthCheck() = get<HealthCheck> {
    call.respond(mapOf("status" to "ok"))
}