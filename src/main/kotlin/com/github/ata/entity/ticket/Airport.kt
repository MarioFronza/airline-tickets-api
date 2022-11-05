package com.github.ata.entity.ticket

import com.github.ata.entity.Entity

data class Airport(
    override val id: Int = -1,
    val name: String,
) : Entity
