package com.github.ata.persistence.dao

import com.github.ata.persistence.utils.limit
import com.github.ata.persistence.utils.order
import com.github.ata.persistence.utils.query
import com.github.ata.usecase.persistence.dto.Order
import com.github.ata.usecase.persistence.dto.Pagination
import com.github.ata.usecase.persistence.dto.PaginationResult
import com.github.ata.usecase.persistence.repository.Repository
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass

abstract class DefaultDAO<Domain : Any, ID : Comparable<ID>, E : Entity<ID>>(
    private val dao: EntityClass<ID, E>
) : Repository<Domain, ID> {
    abstract fun E.toDomain(): Domain

    override suspend fun findById(id: ID) = query {
        dao.findById(id)?.toDomain()
    }

    override suspend fun findAll() = query {
        dao.all().map { it.toDomain() }
    }

    override suspend fun findAll(pagination: Pagination) = query {
        val query = dao.query(pagination)
        PaginationResult(
            query.copy()
                .limit(pagination)
                .order(dao.table, pagination.sort, dao.table.id to Order.ASC)
                .map { it.toDomain() },
            query.copy().count()
        )
    }

    override suspend fun delete(id: ID) = query {
        dao[id].delete()
    }

    override suspend fun count(pagination: Pagination?) = query {
        dao.query(pagination).count()
    }
}