//package com.travel.domain.travel.dto;
//
//import com.travel.domain.travel.domain.JavaTravel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@Getter
//public class JavaTravelSaveDto {
//    private String name;
//    private String userId;
//    private String travelStartDate;
//    private String travelEndDate;
//
//    @Builder
//    public JavaTravelSaveDto(String name, String userId, String travelStartDate, String travelEndDate) {
//        this.name = name;
//        this.userId = userId;
//        this.travelStartDate = travelStartDate;
//        this.travelEndDate = travelEndDate;
//    }
//
//    public JavaTravel toEntity() {
//        return JavaTravel.builder()
//                .name(name)
//                .userId(userId)
//                .travelStartDate(travelStartDate)
//                .travelEndDate(travelEndDate)
//                .build();
//    }
//}
