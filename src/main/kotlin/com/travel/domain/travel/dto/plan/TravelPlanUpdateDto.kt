package com.travel.domain.travel.dto.plan

data class TravelPlanUpdateDto(
        val travelId: Long,
        val place: String? = null,
        val orderNo: Int ?= null,
        val beforeDate: String,
        val afterDate: String,
        val travelDate: String
) {
}