package com.travel.domain.city.dto

import com.travel.domain.city.domain.City
import com.travel.domain.city.domain.CityCategory

data class CityDto(
        val id: Long,
        val name: String,
        val category: CityCategory) {
    companion object {
        fun of(city: City): CityDto {
            return CityDto(
                    id = city.id!!,
                    name = city.name,
                    category = city.category
            )
        }
    }
}