//package com.travel.domain.travel.dto;
//
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@Getter
//public class JavaTravelRequestDto {
//    private Long id;
//    private String name;
//    private String userId;
//    private String travelStartDate;
//    private String travelEndDate;
//    @Enumerated(EnumType.STRING)
//    private JavaTravelSearchType searchType = JavaTravelSearchType.NORMAL;
//
//    @Builder
//    public JavaTravelRequestDto(Long id, String name, String userId, String travelStartDate, String travelEndDate, JavaTravelSearchType searchType) {
//        this.id = id;
//        this.name = name;
//        this.userId = userId;
//        this.travelStartDate = travelStartDate;
//        this.travelEndDate = travelEndDate;
//        this.searchType = searchType;
//    }
//}
