package com.travel.domain.travel.dto.plan

data class TravelPlanUpdateDto(
        val travelId: Long,
        val place: String,
        val orderNo: Int,
        val beforeDate: String,
        val afterDate: String,
        val travelDate: String
) {
}