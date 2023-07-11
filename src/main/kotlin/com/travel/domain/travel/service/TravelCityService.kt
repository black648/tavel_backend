package com.travel.domain.travel.service

import com.travel.domain.travel.domain.city.TravelCity
import com.travel.domain.travel.domain.city.TravelCityQueryDslRepository
import com.travel.domain.travel.domain.city.TravelCityRepository
import com.travel.domain.travel.dto.city.TravelCityDto
import com.travel.global.util.findByIdOrThrow
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TravelCityService(
        private val travelCityRepository: TravelCityRepository,
        private val travelCityQueryDslRepository: TravelCityQueryDslRepository
) {
    @Transactional
    fun save(travelCityDto: TravelCityDto) {
        travelCityRepository.save(travelCityDto.toEntity())
    }

    @Transactional
    fun update(id: Long, cityId: Long) {
        val travelCity: TravelCity = travelCityRepository.findByIdOrThrow(id)
        travelCity.update(cityId)
    }

    @Transactional
    fun delete(id: Long) {
        val travelCity: TravelCity = travelCityRepository.findByIdOrThrow(id)
        travelCityRepository.delete(travelCity)
    }

    @Transactional
    fun deleteAllToTravelId(travelId: Long) {
        if (travelCityRepository.findByTravelId(travelId).isNotEmpty()) {
            travelCityQueryDslRepository.deleteAllToTravelId(travelId)
        }
    }

    fun findByCityId(cityId: Long): List<TravelCity> {
        return travelCityRepository.findByCityId(cityId)
    }
}
