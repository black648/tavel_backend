package com.travel.domain.city.dto

import com.travel.domain.city.domain.CityCategory

data class CityUpdateDto(var name: String, var category: CityCategory)