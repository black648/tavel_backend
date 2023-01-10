package com.travel.domain.travel.controller;

import com.travel.domain.travel.dto.plan.TravelPlanDto;
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto;
import com.travel.domain.travel.service.TravelPlanService;
import com.travel.global.result.ResultApi;
import com.travel.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TravelPlanController {
    private final TravelPlanService travelPlanService;

    @PostMapping("/travelPlan/save")
    public ResultApi save(@RequestBody TravelPlanSaveDto travelPlanSaveDto) {
        return ResultSet.resultData(travelPlanService.save(travelPlanSaveDto));
    }

    @PutMapping("/travelPlan/saveAll")
    public void saveAll(@RequestBody List<TravelPlanSaveDto> travelPlanSaveDtoList) {
        travelPlanService.saveAll(travelPlanSaveDtoList);
    }

    @PostMapping("/travelPlan/getList")
    public ResultApi getList(@RequestBody TravelPlanDto travelPlanDto) {
        return ResultSet.resultList(travelPlanService.getList(travelPlanDto));
    }
}
