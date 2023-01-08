package com.travel.domain.travel.controller;

import com.travel.domain.travel.dto.city.TravelCityDto;
import com.travel.domain.travel.service.TravelCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class TravelCityController {
    private final TravelCityService travelCityService;

    @PostMapping("/travelCity/save")
    public Long save(@RequestBody TravelCityDto travelCityDto) {
        return travelCityService.save(travelCityDto);
    }

    @PutMapping("/travelCity/update/{id}")
    public void update(@RequestBody Map<String, Long> params) {
        try {
            travelCityService.update(params.get("id"), params.get("cityId"));
        } catch (Exception e) {
        }
    }

    @DeleteMapping("/travelCity/delete/{id}")
    public void delete(@PathVariable Long id) {
        travelCityService.delete(id);
    }
}
