//package com.travel.domain.city.controller;
//
//import com.travel.domain.city.dto.CityUpdateDto;
//import com.travel.domain.city.service.CityService;
//import com.travel.global.result.ResultApi;
//import com.travel.global.result.ResultSet;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//public class JavaCityController {
//    private final CityService cityService;
//
//    @PostMapping("/city/save")
//    public ResultApi save(@RequestBody CitySaveDto requestDto) {
//        return ResultSet.resultData(cityService.save(requestDto));
//    }
//
//    @PutMapping("/city/update/{id}")
//    public void update(@PathVariable Long id, @RequestBody CityUpdateDto cityUpdateDto) {
//        cityService.update(id, cityUpdateDto);
//    }
//
//    @DeleteMapping("/city/delete/{id}")
//    public void delete(@PathVariable Long id) {
//        cityService.delete(id);
//    }
//
//    @PostMapping("/city/get/{id}")
//    public ResultApi get(@PathVariable Long id) {
//        return ResultSet.resultData(cityService.get(id));
//    }
//
//    @PostMapping("/city/findCityListByUserIdNative")
//    public ResultApi findCityListByUserIdNative(@PathVariable String userId) {
//        return ResultSet.resultList(cityService.findCityListByUserIdNative(userId));
//    }
//}
