package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.city.TravelCityQueryDslRepository;
import com.travel.domain.travel.domain.city.TravelCityRepository;
import com.travel.domain.travel.dto.city.TravelCityDto;
import com.travel.global.util.MessageUtil;
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
            new IllegalArgumentException(MessageUtil.getMessage("cannot.find.travel.city")));

        travelCity.update(cityId);
    }

    @Transactional
    public void delete(Long id) {
        TravelCity travelCity = travelCityRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(MessageUtil.getMessage("cannot.find.travel.city")));

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
