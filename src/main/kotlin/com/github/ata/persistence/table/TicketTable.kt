package com.github.ata.persistence.table

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.jodatime.datetime

object TicketTable : IntIdTable() {
    val company = reference("company", CompanyTable)
    val origin = reference("origin", AirportTable)
    val destination = reference("destination", AirportTable)
    val date = datetime("date")
}

class TicketExposedEntity(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<TicketExposedEntity>(TicketTable)
}