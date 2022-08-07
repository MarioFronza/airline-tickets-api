package com.github.ata.http.ktor.plugin

import com.github.ata.integration.http.ConnectionHttpClient
import com.github.ata.integration.http.okhttp.ConnectionOkHttpClient
import com.github.ata.integration.ticket.latam.LatamTicketIntegration
import com.github.ata.integration.ticket.latam.extractor.LatamTicketExtractor
import com.github.ata.integration.ticket.latam.step.GetCookiesStep
import com.github.ata.integration.ticket.latam.step.GetTicketsStep
import com.github.ata.usecase.integration.AirlineTicketIntegration
import com.github.ata.usecase.retrieve.RetrieveTicket
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDependencyInjection() {
    install(Koin) {
        modules(appModule)
    }
}

val appModule = module(createdAtStart = true) {
    single<ConnectionHttpClient> { ConnectionOkHttpClient() }

    single { GetCookiesStep(get()) }
    single { GetTicketsStep(get()) }
    single { LatamTicketExtractor(get(), get()) }
    single<AirlineTicketIntegration> { LatamTicketIntegration(get()) }

    single { RetrieveTicket(getAll()) }
}