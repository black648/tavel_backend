//package com.travel.domain.city.service;
//
//import com.travel.domain.city.domain.City;
//import com.travel.domain.city.domain.CityRepository;
//import com.travel.domain.city.domain.log.CityLog;
//import com.travel.domain.city.domain.log.CityLogRepository;
//import com.travel.domain.city.dto.*;
//import com.travel.domain.travel.service.TravelCityService;
//import com.travel.global.util.MessageUtil;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//import java.util.Map;
//
//@RequiredArgsConstructor
//@Service
//public class JavaCityService {
//
//    private final CityRepository cityRepository;
//    private final CityLogRepository cityLogRepository;
//    private final TravelCityService travelCityService;
//
//    @Transactional
//    public Long save(CitySaveDto saveDto) {
//        return 0L;
//    }
//
//    @Transactional
//    public void update(Long id, CityUpdateDto cityUpdateDto) {
//        City City = cityRepository.findById(id).orElseThrow(() ->
//            new IllegalArgumentException("요청한 도시가 존재하지 않습니다."));
//
//        City.update(cityUpdateDto);
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        City City = cityRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException(MessageUtil.getMessage("cannot.find.city")));
//
//        if (CollectionUtils.isEmpty(travelCityService.findByCityId(City.getId()))) {
//            cityRepository.delete(City);
//        }
//    }
//
//    public CityDto get(Long id) {
//        CityDto cityDto = CityDto.of(cityRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException(MessageUtil.getMessage("cannot.find.city"))));
//
//        //도시 이력 저장
//        cityLogRepository.save(new CityLog(cityDto.getId()).toEntity());
//
//        return cityDto;
//    }
//
//    public List<Map<String, Object>> findCityListByUserIdNative(String userId) {
//        return cityRepository.findCityListByUserIdNative(userId);
//    }
//}
