package com.github.ata.persistence.table

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object AirportTable : IntIdTable() {
    val name = varchar("name", 255)
}

class AirportExposedEntity(id: EntityID<Int>) : IntEntity(id) {
    var name by AirportTable.name

    companion object : IntEntityClass<AirportExposedEntity>(AirportTable)
}