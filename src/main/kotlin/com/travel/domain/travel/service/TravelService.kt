package com.travel.domain.travel.service

import com.travel.domain.travel.domain.Travel
import com.travel.domain.travel.domain.TravelQueryDslRepository
import com.travel.domain.travel.domain.TravelRepository
import com.travel.domain.travel.domain.plan.TravelPlanRepository
import com.travel.domain.travel.dto.*
import com.travel.domain.travel.dto.plan.TravelPlanUpdateDto
import com.travel.global.util.DateUtil
import com.travel.global.util.MessageUtil
import com.travel.global.util.findByIdOrThrow
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class TravelService(
        private val travelRepository: TravelRepository,
        private val travelQueryDslRepository: TravelQueryDslRepository,
        private val travelPlanService: TravelPlanService,
        private val travelCityService: TravelCityService,
        private val travelPlanRepository: TravelPlanRepository
) {
    @Transactional
    fun save(travelSaveDto: TravelSaveDto) {
        travelRepository.save(travelSaveDto.toEntity())
    }

    @Transactional
    @Throws(Exception::class)
    fun update(id: Long, travelUpdateDto: TravelUpdateDto) {
        val travel: Travel = travelRepository.findByIdOrThrow(id)
        try {
            //등록된 일정의 시작일보다 신규 일정의 시작일이 늦춰졌을 때
            if (DateUtil.compareTo(travelUpdateDto.travelStartDate, travel.travelStartDate)) {
                //사전에 기존일정 orderNo 신규 갯수만큼 + 하기!
                travelPlanService!!.updateOrder(id,
                        travelUpdateDto.travelStartDate,
                        travelPlanRepository.countByTravelIdAndTravelDate(id, travel.travelStartDate)
                )

                //이전에 등록된 일정 ~ 신규 등록되는 일정 동안 등록된 일정을 신규 등록일로 변경
                travelPlanService.updateTravelDate(TravelPlanUpdateDto(
                        travelId = id,
                        beforeDate = travel.travelStartDate,
                        afterDate = travelUpdateDto.travelStartDate,
                        travelDate = travelUpdateDto.travelStartDate))
            }

            //신규 일정의 종료일보다 기존 일정의 종료일이 앞당겨 졌을 때
            if (DateUtil.compareTo(travel.travelEndDate, travelUpdateDto.travelEndDate)) {
                //사전에 기존일정 orderNo 신규 갯수만큼 + 하기!
                travelPlanService!!.updateOrder(id,
                        travel.travelEndDate,
                        travelPlanRepository.countByTravelIdAndTravelDate(id, travelUpdateDto.travelEndDate)
                )

                //이전 일정 ~ 신규 일정까지 등록된 일정을 신규 일정으로 변경
                travelPlanService.updateTravelDate(TravelPlanUpdateDto(
                        travelId = id,
                        beforeDate = travel.travelEndDate,
                        afterDate = travelUpdateDto.travelEndDate,
                        travelDate = travelUpdateDto.travelEndDate))
            }
            travel.update(travelUpdateDto)
        } catch (e: Exception) {
            throw Exception(MessageUtil.getMessage("travel.update.fail"))
        }
    }

    @Transactional
    fun delete(id: Long) {
        val travel: Travel = travelRepository.findByIdOrThrow(id)

        //여행에 등록된 여행도시 삭제
        travelCityService.deleteAllToTravelId(id)

        //여행에 등록된 여행계획 삭제
        travelPlanService.deleteAllToTravelId(id)

        //여행삭제
        travelRepository.delete(travel)
    }

    operator fun get(requestDto: TravelRequestDto): TravelResponseDto {
        val travelResponseDto: TravelResponseDto
        when (requestDto.searchType) {
            TravelSearchType.PLAN -> travelResponseDto = TravelResponseDto.of(travelQueryDslRepository.getIncludePlan(requestDto)!!)
            TravelSearchType.CITY -> travelResponseDto = TravelResponseDto.of(travelQueryDslRepository.getIncludeCity(requestDto)!!)
            else -> travelResponseDto = TravelResponseDto.of(travelQueryDslRepository.get(requestDto)!!)
        }

        return travelResponseDto
    }
}