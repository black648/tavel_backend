package com.travel.domain.city.controller

import com.travel.domain.city.dto.CityDto
import com.travel.domain.city.dto.CitySaveDto
import com.travel.domain.city.dto.CityUpdateDto
import com.travel.domain.city.service.CityService
import com.travel.global.base.BaseResponse
import org.springframework.web.bind.annotation.*

@RestController
class CityController(
        private val cityService: CityService
) {
    @PostMapping("/city/save")
    fun save(@RequestBody requestDto: CitySaveDto): BaseResponse<Unit> {
        cityService.save(requestDto)
        return BaseResponse(message = "도시 ${requestDto.name}의 등록이 완료되었습니다.")
    }

    @PutMapping("/city/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody cityUpdateDto: CityUpdateDto): BaseResponse<Unit> {
        cityService.update(id, cityUpdateDto)
        return BaseResponse(message = "도시가 수정되었습니다.")
    }

    @DeleteMapping("/city/delete/{id}")
    fun delete(@PathVariable id: Long): BaseResponse<Unit> {
        cityService.delete(id)
        return BaseResponse(message = "도시가 삭제되었습니다.")
    }

    @PostMapping("/city/get/{id}")
    fun get(@PathVariable id: Long): BaseResponse<CityDto> {
        return BaseResponse(data = cityService.get(id))
    }

    @PostMapping("/city/findCityListByUserIdNative")
    fun findCityListByUserIdNative(@PathVariable userId: String): BaseResponse<List<Map<String, Any>>> {
        return BaseResponse(data = cityService.findCityListByUserIdNative(userId))
    }
}