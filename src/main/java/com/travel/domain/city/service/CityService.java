package com.travel.domain.city.service;

import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.request.CitySaveRequestDto;
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
}
