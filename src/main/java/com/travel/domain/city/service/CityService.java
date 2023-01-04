package com.travel.domain.city.service;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.request.CitySaveRequestDto;
import com.travel.domain.city.dto.request.CityUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    @Transactional
    public Long save(CitySaveRequestDto requestDto) {
        return cityRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void update(CityUpdateRequestDto requestDto) {
        City city = cityRepository.findById(requestDto.getId()).orElseThrow(() ->
            new IllegalArgumentException("요청한 도시가 존재하지 않습니다."));

        city.update(requestDto);

    }

}
