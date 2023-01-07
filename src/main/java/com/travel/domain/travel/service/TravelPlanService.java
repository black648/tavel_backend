package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.plan.TravelPlan;
import com.travel.domain.travel.domain.plan.TravelPlanQueryDslRepository;
import com.travel.domain.travel.domain.plan.TravelPlanRepository;
import com.travel.domain.travel.dto.plan.TravelPlanDto;
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TravelPlanService {
    private final TravelPlanRepository travelPlanRepository;
    private final TravelPlanQueryDslRepository travelPlanQueryDslRepository;

    @Transactional
    public Long save(TravelPlanSaveDto travelPlanSaveDto) {
        //순번 값이 없는 경우 등록된 일정의 order max +1 처리
        if (travelPlanSaveDto.getOrderNo() == 0) {
            TravelPlan travelPlan = travelPlanRepository.findTopByTravelIdAndTravelDateOrderByOrderNoDesc(
                    travelPlanSaveDto.getTravelId(), travelPlanSaveDto.getTravelDate());

            travelPlanSaveDto = travelPlanSaveDto.toBuilder()
                    .orderNo(travelPlan == null ? 1 : travelPlan.getOrderNo() + 1).build();
        }
        return travelPlanRepository.save(travelPlanSaveDto.toEntity()).getId();
    }

    @Transactional
    public void saveAll(List<TravelPlanSaveDto> travelPlanSaveDtoList) {
        //delete
        travelPlanRepository.deleteAllByTravelIdAndTravelDate(
                travelPlanSaveDtoList.get(0).getTravelId(), travelPlanSaveDtoList.get(0).getTravelDate());

        //데이터 반영
        travelPlanRepository.flush();

        //해당일 일정 일괄 save
        travelPlanRepository.saveAll(travelPlanSaveDtoList.stream()
                .map(TravelPlanSaveDto::toEntity)
                .collect(Collectors.toList()));

    }

    public List<TravelPlanDto> getList(TravelPlanDto travelPlanDto) {
        return travelPlanQueryDslRepository.getList(travelPlanDto);
    }
}
