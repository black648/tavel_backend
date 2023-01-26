package com.travel.domain.travel.controller

import com.travel.domain.travel.dto.TravelRequestDto
import com.travel.domain.travel.dto.TravelSaveDto
import com.travel.domain.travel.dto.TravelUpdateDto
import com.travel.domain.travel.service.TravelService
import com.travel.global.result.ResultApi
import com.travel.global.result.ResultSet
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
class JavaTravelController(
        private val travelService: TravelService
) {

    @PostMapping("/travel/save")
    fun save(@RequestBody travelSaveDto: TravelSaveDto): ResultApi {
        return ResultSet.resultData(travelService.save(travelSaveDto))
    }

    @PutMapping("/travel/update/{id}")
    @Throws(Exception::class)
    fun update(@PathVariable id: Long, @RequestBody travelUpdateDto: TravelUpdateDto) {
        travelService.update(id, travelUpdateDto)
    }

    @DeleteMapping("/travel/delete/{id}")
    fun delete(@PathVariable id: Long) {
        travelService.delete(id)
    }

    @PostMapping("/travel/get")
    operator fun get(@RequestBody requestDto: TravelRequestDto): ResultApi {
        return ResultSet.resultData(travelService.get(requestDto))
    }
}