//package com.travel.domain.travel.controller;
//
//import com.travel.domain.travel.dto.JavaTravelRequestDto;
//import com.travel.domain.travel.dto.JavaTravelSaveDto;
//import com.travel.domain.travel.dto.JavaTravelUpdateDto;
//import com.travel.domain.travel.service.JavaTravelService;
//import com.travel.global.result.ResultApi;
//import com.travel.global.result.ResultSet;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//public class JavaTravelController {
//    private final JavaTravelService travelService;
//
//    @PostMapping("/travel/save")
//    public ResultApi save(@RequestBody JavaTravelSaveDto travelSaveDto) {
//        return ResultSet.resultData(travelService.save(travelSaveDto));
//    }
//
//    @PutMapping("/travel/update/{id}")
//    public void update(@PathVariable Long id, @RequestBody JavaTravelUpdateDto travelUpdateDto) throws Exception {
//        travelService.update(id, travelUpdateDto);
//    }
//
//    @DeleteMapping("/travel/delete/{id}")
//    public void delete(@PathVariable Long id) {
//        travelService.delete(id);
//    }
//
//    @PostMapping("/travel/get")
//    public ResultApi get(@RequestBody JavaTravelRequestDto requestDto) {
//        return ResultSet.resultData(travelService.get(requestDto));
//    }
//}
