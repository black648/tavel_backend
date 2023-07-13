package com.travel.global.util

import com.querydsl.core.types.Expression
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.*
import org.springframework.data.domain.Sort
import java.time.LocalDateTime


object RepositoryUtil {
    fun equals(str: String?, path: StringPath): BooleanExpression? {
        return if (str != null) path.eq(str) else null
    }

    fun `in`(str: Array<String?>?, path: StringPath): BooleanExpression? {
        return if (str != null) path.`in`(*str) else null
    }

    fun equalsInt(num: Int, path: NumberPath<*>): BooleanExpression? {
        return if (num != 0) path.eq(num as Nothing) else null
    }

    fun equalsLong(num: Long?, path: NumberPath<*>): BooleanExpression? {
        return if (num != null && num != 0L) path.eq(num as Nothing) else null
    }

    fun like(str: String?, path: StringPath): BooleanExpression? {
        return if (str != null) path.like(str) else null
    }

    fun before(str: String?, path: DateTimePath<LocalDateTime?>): BooleanExpression? {
        return if (str != null) path.before(LocalDateTime.parse(str)) else null
    }

    fun after(str: String?, path: DateTimePath<LocalDateTime?>): BooleanExpression? {
        return if (str != null) path.after(LocalDateTime.parse(str)) else null
    }

    fun getOrderSpecifier(sort: Sort, pathBuilder: PathBuilder<*>): List<OrderSpecifier<*>> {
        val orders: MutableList<OrderSpecifier<*>> = ArrayList()
        // Sort
        sort.stream().forEach { order: Sort.Order ->
            val direction = if (order.isAscending) Order.ASC else Order.DESC
            orders.add(OrderSpecifier(direction, pathBuilder[order.property] as Expression<Comparable<*>>))
        }
        return orders
    }
}

