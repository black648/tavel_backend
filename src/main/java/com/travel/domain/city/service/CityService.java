package com.travel.domain.city.service;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.domain.log.CityLog;
import com.travel.domain.city.domain.log.CityLogRepository;
import com.travel.domain.city.dto.CityDto;
import com.travel.domain.city.dto.CitySaveDto;
import com.travel.domain.city.dto.CityUpdateDto;
import com.travel.domain.travel.service.TravelCityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityLogRepository cityLogRepository;
    private final TravelCityService travelCityService;

    @Transactional
    public Long save(CitySaveDto requestDto) {
        return cityRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void update(Long id, CityUpdateDto cityUpdateDto) {
        City city = cityRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("요청한 도시가 존재하지 않습니다."));

        city.update(cityUpdateDto);
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
        CityDto cityDto = CityDto.of(cityRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("요청한 도시가 존재하지 않습니다.")));

        //도시 이력 저장
        cityLogRepository.save(new CityLog(cityDto.getId()).toEntity());

        return cityDto;
    }
}
