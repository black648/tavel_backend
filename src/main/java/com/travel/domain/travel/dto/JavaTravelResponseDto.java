//package com.travel.domain.travel.dto;
//
//import com.travel.domain.travel.domain.JavaTravel;
//import com.travel.domain.travel.domain.city.JavaTravelCity;
//import com.travel.domain.travel.domain.plan.JavaTravelPlan;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor
//@Getter
//public class JavaTravelResponseDto {
//    private Long id;
//    private String name;
//    private String userId;
//    private String travelStartDate;
//    private String travelEndDate;
//    private List<JavaTravelPlan> travelPlanList = new ArrayList<>();
//    private List<JavaTravelCity> travelCityList = new ArrayList<>();
//
//    @Builder
//    public JavaTravelResponseDto(JavaTravel travel) {
//        this.id = travel.getId();
//        this.name = travel.getName();
//        this.userId = travel.getUserId();
//        this.travelStartDate = travel.getTravelStartDate();
//        this.travelEndDate = travel.getTravelEndDate();
//        this.travelPlanList = travel.getTravelPlanList();
//        this.travelCityList = travel.getTravelCityList();
//    }
//}
