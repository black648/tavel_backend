package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.TravelRepository;
import com.travel.domain.travel.dto.TravelSaveDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TravelService {

    private final TravelRepository travelRepository;

    @Transactional
    public Long save(TravelSaveDto travelSaveDto) {
        return travelRepository.save(travelSaveDto.toEntity()).getId();
    }
}
