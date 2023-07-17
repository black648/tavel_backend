package com.travel.domain.travel.controller

import com.travel.domain.travel.dto.TravelRequestDto
import com.travel.domain.travel.dto.TravelResponseDto
import com.travel.domain.travel.dto.TravelSaveDto
import com.travel.domain.travel.dto.TravelUpdateDto
import com.travel.domain.travel.service.TravelService
import com.travel.global.base.BaseResponse
import org.springframework.web.bind.annotation.*

@RestController
class TravelController(
        private val travelService: TravelService
) {

    @PostMapping("/travel/save")
    fun save(@RequestBody travelSaveDto: TravelSaveDto): BaseResponse<Unit> {
        travelService.save(travelSaveDto)

        return BaseResponse(message = "${travelSaveDto.name} 여행이 등록되었습니다.")
    }

    @PutMapping("/travel/update/{id}")
    @Throws(Exception::class)
    fun update(@PathVariable id: Long, @RequestBody travelUpdateDto: TravelUpdateDto): BaseResponse<Unit> {
        travelService.update(id, travelUpdateDto)

        return BaseResponse(message = "여행이 수정되었습니다.")
    }

    @DeleteMapping("/travel/delete/{id}")
    fun delete(@PathVariable id: Long): BaseResponse<Unit>{
        travelService.delete(id)

        return BaseResponse(message = "여행이 삭제되었습니다.")
    }

    @PostMapping("/travel/get")
    operator fun get(@RequestBody requestDto: TravelRequestDto): BaseResponse<TravelResponseDto> {
        return BaseResponse(data = travelService.get(requestDto))
    }
}