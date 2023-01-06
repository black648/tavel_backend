package com.travel.domain.city.controller;

import com.travel.domain.city.dto.CitySaveDto;
import com.travel.domain.city.dto.CityDto;
import com.travel.domain.city.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CityController {
    private final CityService cityService;

    @PostMapping("/city/save")
    public Long save(@RequestBody CitySaveDto requestDto) {
        return cityService.save(requestDto);
    }

    @PutMapping("/city/update")
    public void update(@RequestBody CityDto cityDto) {
        cityService.update(cityDto);
    }

    @DeleteMapping("/city/delete/{id}")
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

    @PostMapping("/city/get/{id}")
    public CityDto get(@PathVariable Long id) {
        return cityService.get(id);
    }
}
