package com.github.ata

import com.github.ata.http.ktor.plugin.configureDependencyInjection
import com.github.ata.http.ktor.server.HttpServer
import io.ktor.server.application.*

fun main(args: Array<String>) {
    HttpServer.start(args)
}

fun Application.module() {
    configureDependencyInjection()
}