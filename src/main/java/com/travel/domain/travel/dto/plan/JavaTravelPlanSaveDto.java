//package com.travel.domain.travel.dto.plan;
//
//import com.travel.domain.travel.domain.plan.JavaTravelPlan;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@NoArgsConstructor
//@Getter
//public class TravelPlanSaveDto {
//    private long travelId;
//    private String travelDate;
//    private String place;
//    private int orderNo;
//
//    @Builder(toBuilder = true)
//    public TravelPlanSaveDto(long travelId, String travelDate, String place, int orderNo) {
//        this.travelId = travelId;
//        this.travelDate = travelDate;
//        this.place = place;
//        this.orderNo = orderNo;
//    }
//
//    public JavaTravelPlan toEntity() {
//        return JavaTravelPlan.builder()
//                .travelId(travelId)
//                .travelDate(travelDate)
//                .place(place)
//                .orderNo(orderNo)
//                .build();
//    }
//
//    public List<JavaTravelPlan> toEntityList(List<TravelPlanSaveDto> saveDtoList) {
//        return saveDtoList.stream()
//                .map(TravelPlanSaveDto::toEntity)
//                .collect(Collectors.toList());
//    }
//}