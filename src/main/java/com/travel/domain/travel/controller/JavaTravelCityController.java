//package com.travel.domain.travel.controller;
//
//import com.travel.domain.travel.dto.city.JavaTravelCityDto;
//import com.travel.domain.travel.service.JavaTravelCityService;
//import com.travel.global.result.ResultApi;
//import com.travel.global.result.ResultSet;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RequiredArgsConstructor
//@RestController
//public class JavaTravelCityController {
//    private final JavaTravelCityService travelCityService;
//
//    @PostMapping("/travelCity/save")
//    public ResultApi save(@RequestBody JavaTravelCityDto travelCityDto) {
//        return ResultSet.resultData(travelCityService.save(travelCityDto));
//    }
//
//    @PutMapping("/travelCity/update/{id}")
//    public void update(@RequestBody Map<String, Long> params) {
//        travelCityService.update(params.get("id"), params.get("cityId"));
//    }
//
//    @DeleteMapping("/travelCity/delete/{id}")
//    public void delete(@PathVariable Long id) {
//        travelCityService.delete(id);
//    }
//}
