package com.travel.domain.city.service;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.CityDto;
import com.travel.domain.city.dto.CitySaveRequestDto;
import com.travel.domain.travel.service.TravelCityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final TravelCityService travelCityService;

    @Transactional
    public Long save(CitySaveRequestDto requestDto) {
        return cityRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void update(CityDto cityDto) {
        City city = cityRepository.findById(cityDto.getId()).orElseThrow(() ->
            new IllegalArgumentException("요청한 도시가 존재하지 않습니다."));

        city.update(cityDto);
    }

    @Transactional
    public void delete(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("요청한 도시가 존재하지 않습니다."));

        if (CollectionUtils.isEmpty(travelCityService.findByCityId(city.getId()))) {
            cityRepository.delete(city);
        }
    }

    public CityDto get(Long id) {
        return CityDto.of(cityRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("요청한 도시가 존재하지 않습니다.")));
    }
}
