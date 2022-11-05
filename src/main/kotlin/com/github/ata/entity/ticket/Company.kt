package com.github.ata.entity.ticket

import com.github.ata.entity.Entity

data class Company(
    override val id: Int = -1,
    val name: String
) : Entity
