package com.travel.domain.travel.dto

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
}