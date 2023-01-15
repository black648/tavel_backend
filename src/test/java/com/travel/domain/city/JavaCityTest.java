//package com.travel.domain.city;
//
//import com.travel.domain.city.domain.CityCategory;
//import com.travel.domain.city.domain.CityRepository;
//import com.travel.domain.city.dto.JavaCitySaveDto;
//import com.travel.domain.city.service.CityService;
//import com.travel.domain.travel.domain.TravelRepository;
//import com.travel.domain.travel.domain.city.TravelCityRepository;
//import com.travel.domain.travel.domain.plan.TravelPlanRepository;
//import com.travel.domain.travel.dto.TravelSaveDto;
//import com.travel.domain.travel.dto.city.TravelCityDto;
//import com.travel.domain.travel.service.TravelCityService;
//import com.travel.domain.travel.service.TravelPlanService;
//import com.travel.domain.travel.service.TravelService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class CityTest {
//    @Autowired
//    TravelService travelService;
//    @Autowired
//    TravelRepository travelRepository;
//    @Autowired
//    TravelPlanService travelPlanService;
//    @Autowired
//    TravelPlanRepository travelPlanRepository;
//    @Autowired
//    TravelCityService travelCityService;
//    @Autowired
//    TravelCityRepository travelCityRepository;
//    @Autowired
//    CityService cityService;
//    @Autowired
//    CityRepository cityRepository;
//
//    @DisplayName("[도시 - MYSQL 에서 테스트] 조회 SQL 수행을 위한 사전데이터 세팅 후 조회조건 및 순서에 맞게 조회")
//    @Test
//    public void selectCityBeforeSetData() {
//        //여행1 등록 - 중복
//        Long travelId = travelService.save(TravelSaveDto.builder().name("경북&충청여행 렛츠 고").userId("gogogo").travelStartDate("20230109").travelEndDate("20230115").build());
//        //중복조회 테스트를 위한 도시등록
//        Long cityId = cityService.save(JavaCitySaveDto.builder().name("제천").category(CityCategory.CHUNGCHEONG).build());
//        Long cityId2 = cityService.save(JavaCitySaveDto.builder().name("대전").category(CityCategory.CHUNGCHEONG).build());
//        Long cityId3 = cityService.save(JavaCitySaveDto.builder().name("서산").category(CityCategory.CHUNGCHEONG).build());
//        Long cityId4 = cityService.save(JavaCitySaveDto.builder().name("태안").category(CityCategory.CHUNGCHEONG).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId).cityId(cityId).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId).cityId(cityId2).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId).cityId(cityId3).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId).cityId(cityId4).build());
//
//        //여행2 등록
//        Long travelId2 = travelService.save(TravelSaveDto.builder().name("충청여행 렛츠 고").userId("gogogo").travelStartDate("20220111").travelEndDate("20230118").build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityId).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityId2).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityId3).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityId4).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("청주").category(CityCategory.CHUNGCHEONG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("충주").category(CityCategory.CHUNGCHEONG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("옥천").category(CityCategory.CHUNGCHEONG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("괴산").category(CityCategory.CHUNGCHEONG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("대구").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("경산").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("영주").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("부산").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("울산").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("창원").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("포항").category(CityCategory.GYEONGSANG).build())).build());
//        travelCityService.save(TravelCityDto.builder().travelId(travelId2).cityId(cityService.save(JavaCitySaveDto.builder().name("울진").category(CityCategory.GYEONGSANG).build())).build());
//
//        //이력조회용 데이터 생성
//        cityService.get(cityId2);
//        cityService.get(cityId2);
//        cityService.get(cityId2);
//        cityService.get(cityId2);
//        cityService.get(cityId2);
//        cityService.get(cityId);
//        cityService.get(cityId);
//        cityService.get(cityId);
//        cityService.get(cityId);
//        cityService.get(cityId3);
//        cityService.get(cityId4);
//        cityService.get(cityId3);
//
//        //도시조회
//        List<Map<String, Object>> list = cityRepository.findCityListByUserIdNative("gogogo");
//        assertThat(list.get(0).get("name")).isEqualTo("제천");
//    }
//
//
//}
