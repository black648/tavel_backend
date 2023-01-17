package com.travel.domain.travel.dto.plan

import com.travel.domain.travel.domain.plan.TravelPlan

data class TravelPlanDto(
        val travelId: Long,
        val travelDate: String,
        val place: String,
        val orderNo: Int
) {
    companion object{
        fun of(travelPlan: TravelPlan): TravelPlanDto {
            return TravelPlanDto(
                    travelId = travelPlan.travelId,
                    travelDate = travelPlan.travelDate,
                    place = travelPlan.place,
                    orderNo = travelPlan.orderNo
            )
        }
    }
}