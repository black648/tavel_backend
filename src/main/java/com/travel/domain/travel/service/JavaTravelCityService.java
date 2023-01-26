//package com.travel.domain.travel.service;
//
//import com.travel.domain.travel.domain.city.JavaTravelCity;
//import com.travel.domain.travel.domain.city.TravelCityQueryDslRepository;
//import com.travel.domain.travel.domain.city.TravelCityRepository;
//import com.travel.domain.travel.dto.city.JavaTravelCityDto;
//import com.travel.global.util.MessageUtil;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class JavaTravelCityService {
//    private final TravelCityRepository travelCityRepository;
//    private final TravelCityQueryDslRepository travelCityQueryDslRepository;
//
//    @Transactional
//    public Long save(JavaTravelCityDto requestDto) {
//        return travelCityRepository.save(requestDto.toEntity()).getId();
//    }
//
//    @Transactional
//    public void update(Long id, Long cityId) {
//        JavaTravelCity travelCity = travelCityRepository.findById(id).orElseThrow(() ->
//            new IllegalArgumentException(MessageUtil.getMessage("cannot.find.travel.city")));
//
//        travelCity.update(cityId);
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        JavaTravelCity travelCity = travelCityRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException(MessageUtil.getMessage("cannot.find.travel.city")));
//
//        travelCityRepository.delete(travelCity);
//    }
//
//    @Transactional
//    public void deleteAllToTravelId(Long travelId) {
//        if(travelCityRepository.findByTravelId(travelId).size() > 0) {
//            travelCityQueryDslRepository.deleteAllToTravelId(travelId);
//        }
//    }
//
//    public List<JavaTravelCity> findByCityId(Long cityId) {
//        return travelCityRepository.findByCityId(cityId);
//    }
//
//}
