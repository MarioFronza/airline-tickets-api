package com.github.ata.usecase.retrieve

import io.mockk.every
import io.mockk.mockk
import com.github.ata.usecase.integration.AirlineTicketIntegration
import com.github.ata.usecase.integration.dto.IntegrationOutput.IntegrationSuccess
import com.github.ata.usecase.integration.dto.IntegrationOutput.IntegrationError
import com.github.ata.usecase.retrieve.dto.RetrieveTicketOutput.RetrieveTicketSuccess
import com.github.ata.usecase.retrieve.dto.RetrieveTicketOutput.RetrieveTicketError
import utils.ModelBuilder.createAirlineTicketIntegrationInput
import utils.ModelBuilder.createAirlineTicketIntegrationOutput
import utils.ModelBuilder.createRetrieveTicketInput
import utils.ModelBuilder.createTicket
import kotlin.test.Test
import kotlin.test.assertEquals

class RetrieveTicketTest {

    private val firstIntegration: AirlineTicketIntegration = mockk()
    private val secondIntegration: AirlineTicketIntegration = mockk()
    private val retrieveTicket = RetrieveTicket(
        listOf(firstIntegration, secondIntegration)
    )

    @Test
    fun `should return retrieve success with smallest ticket price`() {
        val integrationInput = createAirlineTicketIntegrationInput()
        val retrieveTicketInput = createRetrieveTicketInput()

        val firstIntegrationResponse = IntegrationSuccess(
            data = createAirlineTicketIntegrationOutput(
                companyName = "LATAM Airlines Brasil",
                lowestPrice = 100.0
            )
        )

        val secondIntegrationResponse = IntegrationSuccess(
            data = createAirlineTicketIntegrationOutput(
                companyName = "Go Linhas Aéreas Inteligentes",
                lowestPrice = 150.0
            )
        )

        every {
            firstIntegration.integrate(integrationInput)
        } returns firstIntegrationResponse

        every {
            secondIntegration.integrate(integrationInput)
        } returns secondIntegrationResponse

        val expected = RetrieveTicketSuccess(
            ticket = createTicket(
                companyName = "LATAM Airlines Brasil",
                airportOrigin = "FLN",
                airportDestination = "GRU",
                price = 100.0
            )
        )
        val actual = retrieveTicket.retrieve(retrieveTicketInput)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return retrieve success with two integrations returning tickets with same lowest price`() {
        val integrationInput = createAirlineTicketIntegrationInput()
        val retrieveTicketInput = createRetrieveTicketInput()

        val firstIntegrationResponse = IntegrationSuccess(
            data = createAirlineTicketIntegrationOutput(
                companyName = "LATAM Airlines Brasil",
                lowestPrice = 100.0
            )
        )

        val secondIntegrationResponse = IntegrationSuccess(
            data = createAirlineTicketIntegrationOutput(
                companyName = "Go Linhas Aéreas Inteligentes",
                lowestPrice = 100.0
            )
        )

        every {
            firstIntegration.integrate(integrationInput)
        } returns firstIntegrationResponse

        every {
            secondIntegration.integrate(integrationInput)
        } returns secondIntegrationResponse

        val expected = RetrieveTicketSuccess(
            ticket = createTicket(
                companyName = "LATAM Airlines Brasil",
                airportOrigin = "FLN",
                airportDestination = "GRU",
                price = 100.0
            )
        )
        val actual = retrieveTicket.retrieve(retrieveTicketInput)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return retrieve success with smallest ticket price and on integration fail`() {
        val integrationInput = createAirlineTicketIntegrationInput()
        val retrieveTicketInput = createRetrieveTicketInput()

        val firstIntegrationResponse = IntegrationSuccess(
            data = createAirlineTicketIntegrationOutput(
                companyName = "LATAM Airlines Brasil",
                lowestPrice = 100.0
            )
        )

        val secondIntegrationResponse = IntegrationError(
            message = "ERROR"
        )

        every {
            firstIntegration.integrate(integrationInput)
        } returns firstIntegrationResponse

        every {
            secondIntegration.integrate(integrationInput)
        } returns secondIntegrationResponse

        val expected = RetrieveTicketSuccess(
            ticket = createTicket(
                companyName = "LATAM Airlines Brasil",
                airportOrigin = "FLN",
                airportDestination = "GRU",
                price = 100.0
            )
        )
        val actual = retrieveTicket.retrieve(retrieveTicketInput)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return retrieve error when all integration fail`() {
        val integrationInput = createAirlineTicketIntegrationInput()
        val retrieveTicketInput = createRetrieveTicketInput()

        val firstIntegrationResponse = IntegrationError(
            message = "ERROR"
        )

        val secondIntegrationResponse = IntegrationError(
            message = "ERROR"
        )

        every {
            firstIntegration.integrate(integrationInput)
        } returns firstIntegrationResponse

        every {
            secondIntegration.integrate(integrationInput)
        } returns secondIntegrationResponse

        val expected = RetrieveTicketError(
            message = "Could not extract tickets for FLN to GRU"
        )
        val actual = retrieveTicket.retrieve(retrieveTicketInput)

        assertEquals(expected, actual)
    }


//retrieve error all com.github.ata.integration fail

//retrieve success with two valid integrations, tickets with same price (100.0, 100.0)


}