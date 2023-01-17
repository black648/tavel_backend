package com.travel.domain.travel.dto

import com.travel.domain.travel.domain.Travel

data class TravelDto(
        val name: String,
        val userId: String,
        val travelStartDate: String,
        val travelEndDate: String
) {
    companion object {
        fun of(travel: Travel): TravelDto {
            return TravelDto(
            name = travel.name,
            userId = travel.userId,
            travelStartDate = travel.travelStartDate,
            travelEndDate = travel.travelEndDate);
        }
    }
}