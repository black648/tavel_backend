package com.travel.domain.city.controller

import com.travel.domain.city.dto.CitySaveDto
import com.travel.domain.city.dto.CityUpdateDto
import com.travel.domain.city.service.CityService
import com.travel.global.result.ResultApi
import com.travel.global.result.ResultSet
import org.springframework.web.bind.annotation.*

@RestController
class CityController(
        private val cityService: CityService
) {
    @PostMapping("/city/save")
    fun save(@RequestBody requestDto: CitySaveDto) {
        ResultSet.resultData(cityService.save(requestDto))
    }

    @PutMapping("/city/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody cityUpdateDto: CityUpdateDto) {
        cityService.update(id, cityUpdateDto)
    }

    @DeleteMapping("/city/delete/{id}")
    fun delete(@PathVariable id: Long) {
        cityService.delete(id)
    }

    @PostMapping("/city/get/{id}")
    fun get(@PathVariable id: Long): ResultApi {
        return ResultSet.resultData(cityService.get(id))
    }

    @PostMapping("/city/findCityListByUserIdNative")
    fun findCityListByUserIdNative(@PathVariable userId: String): ResultApi {
        return ResultSet.resultList(cityService.findCityListByUserIdNative(userId))
    }
}