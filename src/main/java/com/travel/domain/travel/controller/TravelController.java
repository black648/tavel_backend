package com.travel.domain.travel.controller;

import com.travel.domain.travel.dto.TravelRequestDto;
import com.travel.domain.travel.dto.TravelSaveDto;
import com.travel.domain.travel.dto.TravelUpdateDto;
import com.travel.domain.travel.service.TravelService;
import com.travel.global.result.ResultApi;
import com.travel.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TravelController {
    private final TravelService travelService;

    @PostMapping("/travel/save")
    public ResultApi save(@RequestBody TravelSaveDto travelSaveDto) {
        return ResultSet.resultData(travelService.save(travelSaveDto));
    }

    @PutMapping("/travel/update/{id}")
    public void update(@PathVariable Long id, @RequestBody TravelUpdateDto travelUpdateDto) throws Exception {
        travelService.update(id, travelUpdateDto);
    }

    @DeleteMapping("/travel/delete/{id}")
    public void delete(@PathVariable Long id) {
        travelService.delete(id);
    }

    @PostMapping("/travel/get")
    public ResultApi get(@RequestBody TravelRequestDto requestDto) {
        return ResultSet.resultData(travelService.get(requestDto));
    }
}
