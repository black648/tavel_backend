package com.travel.domain.travel.controller;

import com.travel.domain.travel.dto.city.TravelCityDto;
import com.travel.domain.travel.service.TravelCityService;
import com.travel.global.result.ResultApi;
import com.travel.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class TravelCityController {
    private final TravelCityService travelCityService;

    @PostMapping("/travelCity/save")
    public ResultApi save(@RequestBody TravelCityDto travelCityDto) {
        return ResultSet.resultData(travelCityService.save(travelCityDto));
    }

    @PutMapping("/travelCity/update/{id}")
    public void update(@RequestBody Map<String, Long> params) {
        travelCityService.update(params.get("id"), params.get("cityId"));
    }

    @DeleteMapping("/travelCity/delete/{id}")
    public void delete(@PathVariable Long id) {
        travelCityService.delete(id);
    }
}
