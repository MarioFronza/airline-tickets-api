package com.github.ata.persistence.utils

import com.github.ata.usecase.persistence.dto.Order
import com.github.ata.usecase.persistence.dto.Sort
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.Table


fun <T> SizedIterable<T>.order(table: Table, sort: Sort?, default: Pair<Column<*>, Order>) =
    order(table.columns, sort, default)

fun <T> SizedIterable<T>.order(table: Table, columns: List<Column<*>>, sort: Sort?, default: Pair<Column<*>, Order>) =
    order(table.columns + columns, sort, default)

fun <T> SizedIterable<T>.order(
    columns: List<Column<*>>,
    sort: Sort?,
    default: Pair<Column<*>, Order>
): SizedIterable<T> {
    val column = sort?.by.let { by -> columns.find { it.name == by } } ?: default.first
    val order = (sort?.order ?: default.second).order()
    return orderBy(column to order)
}

fun Order?.order() = when (this ?: Order.ASC) {
    Order.ASC -> SortOrder.ASC
    Order.DESC -> SortOrder.DESC
}