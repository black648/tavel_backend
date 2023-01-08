package com.travel.domain.travel.controller;

import com.travel.domain.travel.dto.TravelRequestDto;
import com.travel.domain.travel.dto.TravelResponseDto;
import com.travel.domain.travel.dto.TravelSaveDto;
import com.travel.domain.travel.dto.TravelUpdateDto;
import com.travel.domain.travel.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TravelController {
    private final TravelService travelService;

    @PostMapping("/travel/save")
    public Long save(@RequestBody TravelSaveDto travelSaveDto) {
        return travelService.save(travelSaveDto);
    }

    @PutMapping("/travel/update/{id}")
    public void update(@PathVariable Long id, @RequestBody TravelUpdateDto travelUpdateDto) {
        try {
            travelService.update(id, travelUpdateDto);
        } catch (Exception e) {
        }
    }

    @DeleteMapping("/travel/delete/{id}")
    public void delete(@PathVariable Long id) {
        travelService.delete(id);
    }

    @PostMapping("/travel/get")
    public TravelResponseDto get(@RequestBody TravelRequestDto requestDto) {
        return travelService.get(requestDto);
    }
}
