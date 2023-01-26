package com.travel.domain.city.service

import com.travel.domain.city.domain.City
import com.travel.domain.city.domain.CityRepository
import com.travel.domain.city.domain.log.CityLog
import com.travel.domain.city.domain.log.CityLogRepository
import com.travel.domain.city.dto.CityDto
import com.travel.domain.city.dto.CitySaveDto
import com.travel.domain.city.dto.CityUpdateDto
import com.travel.domain.travel.service.TravelCityService
import com.travel.global.util.findByIdOrThrow
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.time.LocalDateTime

@Service
class CityService(
        private val cityRepository: CityRepository,
        private val cityLogRepository: CityLogRepository,
        private val travelCityService: TravelCityService
) {
    @Transactional
    fun save(saveDto: CitySaveDto) {
        cityRepository.save(City(saveDto.name, saveDto.category))
    }

    @Transactional
    fun update(id: Long, cityUpdateDto: CityUpdateDto) {
        val city = cityRepository.findByIdOrThrow(id)
        city.update(cityUpdateDto)
    }

    @Transactional
    fun delete(id: Long) {
        val city = cityRepository.findByIdOrThrow(id)

        //여행중인 도시가 아니면 삭제 가능
        if (CollectionUtils.isEmpty(travelCityService.findByCityId(city.id!!))) {
            cityRepository.delete(city)
        }
    }

    fun get(id: Long): CityDto {
        val cityDto = CityDto.of(cityRepository.findByIdOrThrow(id))

        //도시 이력 저장
        cityLogRepository.save(CityLog(cityDto.id,"gogogo", LocalDateTime.now()))
        return cityDto
    }

    fun findCityListByUserIdNative(userId: String): List<Map<String, Any>> {
        return cityRepository.findCityListByUserIdNative(userId)
    }
}