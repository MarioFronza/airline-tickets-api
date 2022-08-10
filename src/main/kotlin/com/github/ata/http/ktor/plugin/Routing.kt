package com.github.ata.http.ktor.plugin

import com.github.ata.http.ktor.controller.healthCheck
import com.github.ata.http.ktor.controller.retrieveSolicitations
import com.github.ata.usecase.solicitation.SolicitationHandler
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    install(Locations)

    val solicitationHandler by inject<SolicitationHandler>()

    routing {
        healthCheck()
        retrieveSolicitations(solicitationHandler)
    }
}