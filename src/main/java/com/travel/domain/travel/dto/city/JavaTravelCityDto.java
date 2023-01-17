//package com.travel.domain.travel.dto.city;
//
//import com.travel.domain.travel.domain.city.JavaTravelCity;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@Getter
//public class JavaTravelCityDto {
//    private Long travelId;
//    private Long cityId;
//
//    @Builder
//    public JavaTravelCityDto(Long travelId, Long cityId) {
//        this.travelId = travelId;
//        this.cityId = cityId;
//    }
//
//    public JavaTravelCity toEntity() {
//        return JavaTravelCity.builder()
//                .travelId(travelId)
//                .cityId(cityId)
//                .build();
//    }
//}
