package com.travel.domain.travel.dto

import com.travel.domain.travel.domain.Travel
import com.travel.domain.travel.domain.city.TravelCity
import com.travel.domain.travel.domain.plan.TravelPlan

data class TravelResponseDto(
        val id: Long,
        val name: String,
        val userId: String,
        val travelStartDate: String,
        val travelEndDate: String,
        val travelPlanList: List<TravelPlan> = mutableListOf(),
        val travelCityList: List<TravelCity> = mutableListOf()
) {
    companion object {
        fun of(travel: Travel): TravelResponseDto  {
            return TravelResponseDto(
                    id = travel.id!!, //null 아님
                    name = travel.name,
                    userId = travel.userId,
                    travelStartDate = travel.travelStartDate,
                    travelEndDate = travel.travelEndDate,
                    travelPlanList = travel.travelPlanList,
                    travelCityList = travel.travelCityList
            )
        }
    }
}