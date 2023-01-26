package com.travel.domain.travel.controller

import com.travel.domain.travel.dto.plan.TravelPlanDto
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto
import com.travel.domain.travel.service.TravelPlanService
import com.travel.global.result.ResultApi
import com.travel.global.result.ResultSet
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
class JavaTravelPlanController(
        private val travelPlanService: TravelPlanService
) {
    @PostMapping("/travelPlan/save")
    fun save(@RequestBody travelPlanSaveDto: TravelPlanSaveDto): ResultApi {
        return ResultSet.resultData(travelPlanService.save(travelPlanSaveDto))
    }

    @PutMapping("/travelPlan/saveAll")
    fun saveAll(@RequestBody travelPlanSaveDtoList: List<TravelPlanSaveDto>) {
        travelPlanService.saveAll(travelPlanSaveDtoList)
    }

    @PostMapping("/travelPlan/getList")
    fun getList(@RequestBody travelPlanDto: TravelPlanDto): ResultApi {
        return ResultSet.resultList(travelPlanService.getList(travelPlanDto))
    }
}