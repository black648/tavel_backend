package com.travel.domain.travel.domain.plan

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.travel.domain.travel.dto.plan.TravelPlanUpdateDto
import com.travel.global.util.RepositoryUtil
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

import com.travel.domain.travel.domain.plan.QTravelPlan.travelPlan
import com.travel.domain.travel.dto.plan.TravelPlanDto

@Repository
class TravelPlanQueryDslRepository(em: EntityManager?) {
    private val queryFactory: JPAQueryFactory

    init {
        queryFactory = JPAQueryFactory(em)
    }

    fun updateTravelDate(updateDto: TravelPlanUpdateDto): Long {
        return queryFactory.update(travelPlan)
                .where(travelPlan.travelId.eq(updateDto.travelId),
                        travelPlan.travelDate.between(updateDto.beforeDate, updateDto.afterDate))
                .set(travelPlan.travelDate, updateDto.travelDate)
                .execute()
    }

    fun updateOrder(travelId: Long, travelDate: String, addCount: Long): Long {
        return queryFactory.update(travelPlan)
                .where(travelPlan.travelId.eq(travelId), travelPlan.travelDate.eq(travelDate))
                .set(travelPlan.orderNo, travelPlan.orderNo.add(addCount))
                .execute()
    }

    fun deleteAllToTravelId(travelId: Long) {
        queryFactory.delete(travelPlan).where(travelPlan.travelId.eq(travelId)).execute()
    }

    fun getList(travelPlanDto: TravelPlanDto): List<TravelPlanDto> {
        return queryFactory.select(Projections.fields(TravelPlanDto::class.java, travelPlan))
                .from(travelPlan)
                .where(
                        RepositoryUtil.equalsLong(travelPlanDto.travelId, travelPlan.travelId),
                        RepositoryUtil.equals(travelPlanDto.travelDate, travelPlan.travelDate),
                        RepositoryUtil.equals(travelPlanDto.place, travelPlan.place),
                        RepositoryUtil.equalsInt(travelPlanDto.orderNo, travelPlan.orderNo))
                .fetch()
    }
}