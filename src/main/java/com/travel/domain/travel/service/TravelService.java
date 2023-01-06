package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.Travel;
import com.travel.domain.travel.domain.TravelRepository;
import com.travel.domain.travel.dto.TravelSaveDto;
import com.travel.domain.travel.dto.TravelUpdateDto;
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

    @Transactional
    public void update(Long id, TravelUpdateDto travelUpdateDto) {
        Travel travel = travelRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("요청한 여행이 존재하지 않습니다."));

        travel.update(travelUpdateDto);
    }

    @Transactional
    public void delete(Long id) {
        Travel travel = travelRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("요청한 여행이 존재하지 않습니다."));

        //여행도시 삭제

        //여행계획 삭제

        //여행삭제
        travelRepository.delete(travel);
    }
}
