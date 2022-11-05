package com.github.ata.entity.ticket

import com.github.ata.entity.Entity

data class Ticket(
    override val id: Int = -1,
    val company: Company,
    val origin: Airport,
    val destination: Airport,
    val date: String,
    val price: Double
) : Entity
