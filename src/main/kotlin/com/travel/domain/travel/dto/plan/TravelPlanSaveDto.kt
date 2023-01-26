package com.travel.domain.travel.dto.plan

import com.travel.domain.travel.domain.plan.TravelPlan

data class TravelPlanSaveDto(
        val travelId: Long,
        val travelDate: String,
        val place: String,
        var orderNo: Int = 1
) {
    fun toEntity(): TravelPlan {
        return TravelPlan(
                travelId = travelId,
                travelDate = travelDate,
                place = place,
                orderNo = orderNo
        )
    }
}