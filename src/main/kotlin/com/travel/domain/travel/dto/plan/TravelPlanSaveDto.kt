package com.travel.domain.travel.dto.plan

data class TravelPlanSaveDto(
        val travelId: Long,
        val travelDate: String,
        val place: String,
        val orderNo: Int
) {
}