package com.travel.domain.travel.controller

import com.travel.domain.travel.dto.plan.TravelPlanDto
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto
import com.travel.domain.travel.service.TravelPlanService
import com.travel.global.base.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TravelPlanController(
        private val travelPlanService: TravelPlanService
) {
    @PostMapping("/travelPlan/save")
    fun save(@RequestBody travelPlanSaveDto: TravelPlanSaveDto): BaseResponse<Unit> {
        travelPlanService.save(travelPlanSaveDto)

        return BaseResponse(message = "${travelPlanSaveDto.place}의 계획이 등록되었습니다.")
    }

    @PutMapping("/travelPlan/saveAll")
    fun saveAll(@RequestBody travelPlanSaveDtoList: List<TravelPlanSaveDto>): BaseResponse<Unit> {
        travelPlanService.saveAll(travelPlanSaveDtoList)

        return BaseResponse(message = "계획이 저장되었습니다.")
    }

    @PostMapping("/travelPlan/getList")
    fun getList(@RequestBody travelPlanDto: TravelPlanDto): BaseResponse<List<TravelPlanDto>> {
        return BaseResponse(data = travelPlanService.getList(travelPlanDto))
    }
}