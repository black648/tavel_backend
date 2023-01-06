package com.travel.domain.city.controller;

import com.travel.domain.city.dto.CitySaveRequestDto;
import com.travel.domain.city.dto.CityDto;
import com.travel.domain.city.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CityController {
    private final CityService cityService;

    @PostMapping("/city/save")
    public Long save(@RequestBody CitySaveRequestDto requestDto) {
        return cityService.save(requestDto);
    }

    @PutMapping("/city/update")
    public void update(@RequestBody CityDto cityDto) {
        cityService.update(cityDto);
    }

    @DeleteMapping("/city/delete")
    public void delete(@PathVariable Long id) {

    }

}
