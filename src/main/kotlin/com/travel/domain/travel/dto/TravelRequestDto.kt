package com.travel.domain.travel.dto

data class TravelRequestDto(
        val id: Long,
        val name: String,
        val userId: String,
        val travelStartDate: String,
        val travelEndDate: String,
        val searchType: TravelSearchType
) {
}