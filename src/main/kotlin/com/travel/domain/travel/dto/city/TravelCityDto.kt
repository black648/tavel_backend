package com.travel.domain.travel.dto.city

import com.travel.domain.travel.domain.city.TravelCity

data class TravelCityDto(
        val travelId: Long,
        val cityId: Long,
        val orderNo: Int = 1
) {
    fun toEntity(): TravelCity {
        return TravelCity(
                travelId = travelId,
                cityId = cityId,
                orderNo = orderNo
        )
    }
}