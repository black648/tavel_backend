//package com.travel.domain.travel.service;
//
//import com.travel.domain.travel.domain.JavaTravel;
//import com.travel.domain.travel.domain.JavaTravelQueryDslRepository;
//import com.travel.domain.travel.domain.TravelRepository;
//import com.travel.domain.travel.domain.plan.JavaTravelPlanRepository;
//import com.travel.domain.travel.dto.plan.JavaTravelPlanUpdateDto;
//import com.travel.global.util.DateUtil;
//import com.travel.global.util.MessageUtil;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class JavaTravelService {
//    private final TravelRepository travelRepository;
//    private final JavaTravelQueryDslRepository travelQueryDslRepository;
//    private final JavaTravelPlanService travelPlanService;
//    private final JavaTravelCityService travelCityService;
//
//    private final JavaTravelPlanRepository travelPlanRepository;
//
//    @Transactional
//    public Long save(JavaTravelSaveDto travelSaveDto) {
//        return travelRepository.save(travelSaveDto.toEntity()).getId();
//    }
//
//    @Transactional
//    public void update(Long id, JavaTravelUpdateDto travelUpdateDto) throws Exception {
//        JavaTravel travel = travelRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException(MessageUtil.getMessage("cannot.find.travel")));
//        try {
//            //등록된 일정의 시작일보다 신규 일정의 시작일이 늦춰졌을 때
//            if(DateUtil.compareTo(travelUpdateDto.getTravelStartDate(), travel.getTravelStartDate())) {
//                //사전에 기존일정 orderNo 신규 갯수만큼 + 하기!
//                travelPlanService.updateOrder(id,
//                        travelUpdateDto.getTravelStartDate(),
//                        travelPlanRepository.countByTravelIdAndTravelDate(id, travel.getTravelStartDate())
//                        );
//
//                //이전에 등록된 일정 ~ 신규 등록되는 일정 동안 등록된 일정을 신규 등록일로 변경
//                travelPlanService.updateTravelDate(JavaTravelPlanUpdateDto.builder()
//                                .travelId(id)
//                                .beforeDate(travel.getTravelStartDate())
//                                .afterDate(travelUpdateDto.getTravelStartDate())
//                                .travelDate(travelUpdateDto.getTravelStartDate())
//                        .build());
//            }
//
//            //신규 일정의 종료일보다 기존 일정의 종료일이 앞당겨 졌을 때
//            if(DateUtil.compareTo(travel.getTravelEndDate(), travelUpdateDto.getTravelEndDate()))  {
//                //사전에 기존일정 orderNo 신규 갯수만큼 + 하기!
//                travelPlanService.updateOrder(id,
//                        travel.getTravelEndDate(),
//                        travelPlanRepository.countByTravelIdAndTravelDate(id, travelUpdateDto.getTravelEndDate())
//                );
//
//                //이전 일정 ~ 신규 일정까지 등록된 일정을 신규 일정으로 변경
//                travelPlanService.updateTravelDate(JavaTravelPlanUpdateDto.builder()
//                        .travelId(id)
//                        .beforeDate(travelUpdateDto.getTravelEndDate())
//                        .afterDate(travel.getTravelEndDate())
//                        .travelDate(travelUpdateDto.getTravelEndDate())
//                        .build());
//            }
//            travel.update(travelUpdateDto);
//        } catch (Exception e) {
//            throw new Exception(MessageUtil.getMessage("travel.update.fail"));
//        }
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        JavaTravel travel = travelRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException(MessageUtil.getMessage("cannot.find.travel")));
//
//        //여행에 등록된 여행도시 삭제
//        travelCityService.deleteAllToTravelId(id);
//
//        //여행에 등록된 여행계획 삭제
//        travelPlanService.deleteAllToTravelId(id);
//
//        //여행삭제
//        travelRepository.delete(travel);
//    }
//
//    public JavaTravelResponseDto get(JavaTravelRequestDto requestDto) {
//        JavaTravelSearchType searchType = requestDto.getSearchType() == null
//                ? JavaTravelSearchType.NORMAL: requestDto.getSearchType();
//
//        JavaTravelResponseDto travelResponseDto;
//        switch (searchType) {
//            //단일 여행 건 조회 (여행계획 포함)
//            case PLAN -> travelResponseDto = new JavaTravelResponseDto(travelQueryDslRepository.getIncludePlan(requestDto));
//            //단일 여행 건 조회 (여행도시 포함)
//            case CITY -> travelResponseDto = new JavaTravelResponseDto(travelQueryDslRepository.getIncludeCity(requestDto));
//            //단일 여행 Join(X)
//            default -> travelResponseDto = new JavaTravelResponseDto(travelQueryDslRepository.get(requestDto));
//        }
//
//        return travelResponseDto;
//    }
//}
