package com.travel.domain.travel.dto

data class TravelSaveDto(
        val name: String,
        val userId: String,
        val travelStartDate: String,
        val travelEndDate: String
) {
}