package com.travel.domain.travel.domain.city

import org.springframework.data.jpa.repository.JpaRepository

interface TravelCityRepository: JpaRepository<TravelCity, Long> {
    fun findByTravelId(travelId: Long): List<TravelCity>
    fun findByCityId(cityId: Long): List<TravelCity>
}