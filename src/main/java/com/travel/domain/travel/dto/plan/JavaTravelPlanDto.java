//package com.travel.domain.travel.dto.plan;
//
//import com.travel.domain.travel.domain.plan.JavaTravelPlan;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@Getter
//public class JavaTravelPlanDto {
//    private Long id;
//    private Long travelId;
//    private String travelDate;
//    private String place;
//    private int orderNo;
//
//    @Builder
//    public JavaTravelPlanDto(Long id, Long travelId, String travelDate, String place, int orderNo) {
//        this.id = id;
//        this.travelId = travelId;
//        this.travelDate = travelDate;
//        this.place = place;
//        this.orderNo = orderNo;
//    }
//
//    public static JavaTravelPlanDto of(JavaTravelPlan travelPlan) {
//        return new JavaTravelPlanDto(
//                travelPlan.getId(),
//                travelPlan.getTravelId(),
//                travelPlan.getTravelDate(),
//                travelPlan.getPlace(),
//                travelPlan.getOrderNo());
//    }
//}
