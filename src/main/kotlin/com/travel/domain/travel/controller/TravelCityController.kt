package com.travel.domain.travel.controller

import com.travel.domain.travel.dto.city.TravelCityDto
import com.travel.domain.travel.service.TravelCityService
import com.travel.global.base.BaseResponse
import org.springframework.web.bind.annotation.*

@RestController
class TravelCityController(
       private val travelCityService: TravelCityService
) {
    @PostMapping("/travelCity/save")
    fun save(@RequestBody travelCityDto: TravelCityDto): BaseResponse<Unit> {
       travelCityService.save(travelCityDto)

        return BaseResponse(message = "여행도시가 등록되었습니다.")
    }

    @PutMapping("/travelCity/update/{id}")
    fun update(@RequestBody params: Map<String, Long>): BaseResponse<Unit> {
        travelCityService.update(params["id"]!!, params["cityId"]!!)

        return BaseResponse(message = "여행도시가 수정되었습니다.")
    }

    @DeleteMapping("/travelCity/delete/{id}")
    fun delete(@PathVariable id: Long) : BaseResponse<Unit>{
        travelCityService.delete(id)

        return BaseResponse(message = "여행도시가 삭제되었습니다.")
    }
}