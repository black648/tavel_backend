//package com.travel.domain.travel.dto;
//
//import com.travel.domain.travel.domain.JavaTravel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@Getter
//public class JavaTravelDto {
//    private String name;
//    private String userId;
//    private String travelStartDate;
//    private String travelEndDate;
//
//    @Builder
//    public JavaTravelDto(Long id, String name, String userId, String travelStartDate, String travelEndDate) {
//        this.name = name;
//        this.userId = userId;
//        this.travelStartDate = travelStartDate;
//        this.travelEndDate = travelEndDate;
//    }
//
//    public static JavaTravelDto of(JavaTravel travel) {
//        return new JavaTravelDto(
//                travel.getId(),
//                travel.getName(),
//                travel.getUserId(),
//                travel.getTravelStartDate(),
//                travel.getTravelEndDate());
//    }
//}
