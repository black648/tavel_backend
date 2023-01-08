package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.city.TravelCityQueryDslRepository;
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
    private final TravelCityQueryDslRepository travelCityQueryDslRepository;

    @Transactional
    public Long save(TravelCityDto requestDto) {
        return travelCityRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void update(Long id, Long cityId) {
        TravelCity travelCity = travelCityRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("요청한 도시의 여행정보가 존재하지 않습니다."));

        travelCity.update(cityId);
    }

    @Transactional
    public void delete(Long id) {
        TravelCity travelCity = travelCityRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("요청한 도시의 여행정보가 존재하지 않습니다."));

        travelCityRepository.delete(travelCity);
    }

    @Transactional
    public void deleteAllToTravelId(Long travelId) {
        if(travelCityRepository.findByTravelId(travelId).size() > 0) {
            travelCityQueryDslRepository.deleteAllToTravelId(travelId);
        }
    }

    public List<TravelCity> findByCityId(Long cityId) {
        return travelCityRepository.findByCityId(cityId);
    }

}
