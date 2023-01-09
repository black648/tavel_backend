package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.plan.TravelPlan;
import com.travel.domain.travel.domain.plan.TravelPlanQueryDslRepository;
import com.travel.domain.travel.domain.plan.TravelPlanRepository;
import com.travel.domain.travel.dto.plan.TravelPlanDto;
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto;
import com.travel.domain.travel.dto.plan.TravelPlanUpdateDto;
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

    //일괄 삭제 후 등록
    @Transactional
    public void saveAll(List<TravelPlanSaveDto> travelPlanSaveDtoList) {
        //delete
        travelPlanRepository.deleteAllByTravelIdAndTravelDate(
                travelPlanSaveDtoList.get(0).getTravelId(), travelPlanSaveDtoList.get(0).getTravelDate());

        //해당일 일정 일괄 save
        travelPlanRepository.saveAll(travelPlanSaveDtoList.stream()
                .map(TravelPlanSaveDto::toEntity)
                .collect(Collectors.toList()));
    }

    //여행일정 변경
    @Transactional
    public Long updateTravelDate(TravelPlanUpdateDto updateDto) {
        return travelPlanQueryDslRepository.updateTravelDate(updateDto);
    }

    //orderNo 재조정
    @Transactional
    public Long updateOrder(Long travelId, String travelDate, Long addCount) {
        return travelPlanQueryDslRepository.updateOrder(travelId, travelDate, addCount);
    }

    //travelId로 등록된 여행일정들 삭제
    @Transactional
    public void deleteAllToTravelId(Long travelId) {
        if (travelPlanRepository.findByTravelId(travelId).size() > 0) {
            travelPlanQueryDslRepository.deleteAllToTravelId(travelId);
        }
    }

    public List<TravelPlanDto> getList(TravelPlanDto travelPlanDto) {
        return travelPlanQueryDslRepository.getList(travelPlanDto);
    }
}
