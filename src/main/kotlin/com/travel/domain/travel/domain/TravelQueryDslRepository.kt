package com.travel.domain.travel.domain

import com.querydsl.jpa.impl.JPAQueryFactory
import com.travel.domain.travel.domain.QTravel.travel
import com.travel.domain.travel.domain.city.QTravelCity.travelCity
import com.travel.domain.travel.domain.plan.QTravelPlan.travelPlan
import com.travel.domain.travel.dto.TravelRequestDto
import com.travel.global.util.RepositoryUtil
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class TravelQueryDslRepository(em: EntityManager?) {
    private val queryFactory: JPAQueryFactory

    init {
        queryFactory = JPAQueryFactory(em)
    }

    fun get(requestDto: TravelRequestDto): Travel? {
        return queryFactory.select(travel)
                .from(travel)
                .where(
                        RepositoryUtil.equalsLong(requestDto.id, travel.id),
                        RepositoryUtil.equals(requestDto.name, travel.name),
                        RepositoryUtil.equals(requestDto.userId, travel.userId),
                        RepositoryUtil.equals(requestDto.travelStartDate, travel.travelStartDate),
                        RepositoryUtil.equals(requestDto.travelEndDate, travel.travelEndDate))
                .fetchOne()
    }

    fun getIncludePlan(requestDto: TravelRequestDto): Travel? {
        return queryFactory.select(travel)
                .from(travel)
                .where(
                        RepositoryUtil.equalsLong(requestDto.id, travel.id),
                        RepositoryUtil.equals(requestDto.name, travel.name),
                        RepositoryUtil.equals(requestDto.userId, travel.userId),
                        RepositoryUtil.equals(requestDto.travelStartDate, travel.travelStartDate),
                        RepositoryUtil.equals(requestDto.travelEndDate, travel.travelEndDate))
                .leftJoin(travel.travelPlanList, travelPlan).fetchJoin()
                .fetchOne()
    }

    fun getIncludeCity(requestDto: TravelRequestDto): Travel? {
        return queryFactory.select(travel)
                .from(travel)
                .where(
                        RepositoryUtil.equalsLong(requestDto.id, travel.id),
                        RepositoryUtil.equals(requestDto.name, travel.name),
                        RepositoryUtil.equals(requestDto.userId, travel.userId),
                        RepositoryUtil.equals(requestDto.travelStartDate, travel.travelStartDate),
                        RepositoryUtil.equals(requestDto.travelEndDate, travel.travelEndDate))
                .leftJoin(travel.travelCityList, travelCity).fetchJoin()
                .fetchOne()
    }
}