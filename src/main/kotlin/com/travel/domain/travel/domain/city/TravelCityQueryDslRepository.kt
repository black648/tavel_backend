package com.travel.domain.travel.domain.city

import com.querydsl.jpa.impl.JPAQueryFactory
import com.travel.domain.travel.domain.city.QTravelCity.travelCity
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class TravelCityQueryDslRepository(em: EntityManager?) {
    private val queryFactory: JPAQueryFactory

    init {
        queryFactory = JPAQueryFactory(em)
    }

    fun deleteAllToTravelId(travelId: Long) {
        queryFactory.delete(travelCity).where(travelCity.travelId.eq(travelId)).execute()
    }
}