package com.travel.domain.travel.controller

import com.travel.domain.travel.dto.city.TravelCityDto
import com.travel.domain.travel.service.TravelCityService
import com.travel.global.result.ResultSet
import org.springframework.web.bind.annotation.*

@RestController
class TravelCityController(
       private val travelCityService: TravelCityService
) {
    @PostMapping("/travelCity/save")
    fun save(@RequestBody travelCityDto: TravelCityDto) {
       ResultSet.resultData(travelCityService.save(travelCityDto))
    }

    @PutMapping("/travelCity/update/{id}")
    fun update(@RequestBody params: Map<String, Long>) {
        travelCityService.update(params["id"]!!, params["cityId"]!!)
    }

    @DeleteMapping("/travelCity/delete/{id}")
    fun delete(@PathVariable id: Long) {
        travelCityService.delete(id)
    }
}