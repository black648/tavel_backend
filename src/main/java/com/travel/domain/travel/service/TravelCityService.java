package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.city.TravelCityRepository;
import com.travel.domain.travel.dto.city.TravelCityDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TravelCityService {
    private final TravelCityRepository travelCityRepository;

    @Transactional
    public Long save(TravelCityDto requestDto) {
        return travelCityRepository.save(requestDto.toEntity()).getId();
    }

    // TODO: 2023/01/06 삭제 로직 구현 필요

    public List<TravelCity> findByTravelId(Long travelId) {
        return travelCityRepository.findByTravelId(travelId);
    }

    public List<TravelCity> findByCityId(Long cityId) {
        return travelCityRepository.findByCityId(cityId);
    }

}
