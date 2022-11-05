package com.github.ata.persistence.table

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object CompanyTable : IntIdTable() {
    val name = varchar("name", 255)
}

class CompanyExposedEntity(id: EntityID<Int>) : IntEntity(id) {
    var name by CompanyTable.name

    companion object : IntEntityClass<CompanyExposedEntity>(CompanyTable)

}