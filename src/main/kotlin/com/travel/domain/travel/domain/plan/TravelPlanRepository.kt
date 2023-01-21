package com.travel.domain.travel.domain.plan

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying

interface TravelPlanRepository: JpaRepository<TravelPlan, Long> {
    fun findTopByTravelIdAndTravelDateOrderByOrderNoDesc(travelId: Long?, TravelDate: String?): TravelPlan?
    fun findByTravelId(travelId: Long?): List<TravelPlan?>?
    fun findByTravelIdAndTravelDate(travelId: Long?, travelDate: String?): List<TravelPlan?>?

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    fun deleteAllByTravelIdAndTravelDate(travelId: Long?, TravelDate: String?)

    fun countByTravelIdAndTravelDate(travelId: Long?, travelDate: String?): Long?
}