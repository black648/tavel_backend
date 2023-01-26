package com.travel.domain.travel.dto

import com.travel.domain.travel.domain.Travel

data class TravelSaveDto(
        val name: String,
        val userId: String,
        val travelStartDate: String,
        val travelEndDate: String
) {
    fun toEntity(): Travel {
        return Travel(
                name = name,
                userId = userId,
                travelStartDate = travelStartDate,
                travelEndDate = travelEndDate
        )
    }
}