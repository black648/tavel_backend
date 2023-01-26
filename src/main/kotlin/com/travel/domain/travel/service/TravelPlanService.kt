package com.travel.domain.travel.service

import com.travel.domain.travel.domain.plan.TravelPlan
import com.travel.domain.travel.domain.plan.TravelPlanQueryDslRepository
import com.travel.domain.travel.domain.plan.TravelPlanRepository
import com.travel.domain.travel.dto.plan.TravelPlanDto
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto
import com.travel.domain.travel.dto.plan.TravelPlanUpdateDto
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@RequiredArgsConstructor
@Service
class TravelPlanService(
        private val travelPlanRepository: TravelPlanRepository,
        private val travelPlanQueryDslRepository: TravelPlanQueryDslRepository
) {
    @Transactional
    fun save(travelPlanSaveDto: TravelPlanSaveDto) {
        var travelPlanSaveDto = travelPlanSaveDto

        //순번 값이 없는 경우 등록된 일정의 order max +1 처리
        if (travelPlanSaveDto.orderNo == 0) {
            val travelPlan: TravelPlan = travelPlanRepository.findTopByTravelIdAndTravelDateOrderByOrderNoDesc(
                    travelPlanSaveDto.travelId, travelPlanSaveDto.travelDate)

            travelPlanSaveDto.orderNo = if (travelPlan == null) 1 else travelPlan.orderNo + 1
        }

        travelPlanRepository.save(travelPlanSaveDto.toEntity())
    }

    //일괄 삭제 후 등록
    @Transactional
    fun saveAll(travelPlanSaveDtoList: List<TravelPlanSaveDto>) {
        //delete
        travelPlanRepository.deleteAllByTravelIdAndTravelDate(
                travelPlanSaveDtoList[0].travelId, travelPlanSaveDtoList[0].travelDate)

        //해당일 일정 일괄 save
        travelPlanRepository.saveAll(travelPlanSaveDtoList.stream()
                .map(TravelPlanSaveDto::toEntity)
                .collect(Collectors.toList()))
    }

    //여행일정 변경
    @Transactional
    fun updateTravelDate(updateDto: TravelPlanUpdateDto): Long {
        return travelPlanQueryDslRepository.updateTravelDate(updateDto)
    }

    //orderNo 재조정
    @Transactional
    fun updateOrder(travelId: Long, travelDate: String, addCount: Long): Long {
        return travelPlanQueryDslRepository.updateOrder(travelId, travelDate, addCount)
    }

    //travelId로 등록된 여행일정들 삭제
    @Transactional
    fun deleteAllToTravelId(travelId: Long) {
        if (travelPlanRepository.findByTravelId(travelId).isNotEmpty()) {
            travelPlanQueryDslRepository.deleteAllToTravelId(travelId)
        }
    }

    fun getList(travelPlanDto: TravelPlanDto): List<TravelPlanDto> {
        return travelPlanQueryDslRepository.getList(travelPlanDto)
    }
}