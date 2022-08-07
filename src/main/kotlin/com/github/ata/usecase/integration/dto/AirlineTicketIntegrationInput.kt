package com.github.ata.usecase.integration.dto

data class AirlineTicketIntegrationInput(
    val origin: String,
    val destination: String,
    val date: String
)
