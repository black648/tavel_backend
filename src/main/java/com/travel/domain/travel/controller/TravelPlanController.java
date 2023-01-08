package com.travel.domain.travel.controller;

import com.travel.domain.travel.dto.plan.TravelPlanDto;
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto;
import com.travel.domain.travel.service.TravelPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TravelPlanController {
    private final TravelPlanService travelPlanService;

    @PostMapping("/travelPlan/save")
    public Long save(@RequestBody TravelPlanSaveDto travelPlanSaveDto) {
        return travelPlanService.save(travelPlanSaveDto);
    }

    @PutMapping("/travelPlan/saveAll")
    public void saveAll(@RequestBody List<TravelPlanSaveDto> travelPlanSaveDtoList) {
        travelPlanService.saveAll(travelPlanSaveDtoList);
    }

    @PostMapping("/travelPlan/getList")
    public List<TravelPlanDto> getList(@RequestBody TravelPlanDto travelPlanDto) {
        return travelPlanService.getList(travelPlanDto);
    }
}
