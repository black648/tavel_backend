//package com.travel.domain.travel;
//
//import com.travel.domain.city.domain.CityCategory;
//import com.travel.domain.city.dto.JavaCitySaveDto;
//import com.travel.domain.city.service.CityService;
//import com.travel.domain.travel.domain.Travel;
//import com.travel.domain.travel.domain.TravelRepository;
//import com.travel.domain.travel.domain.city.TravelCity;
//import com.travel.domain.travel.domain.city.TravelCityRepository;
//import com.travel.domain.travel.domain.plan.TravelPlan;
//import com.travel.domain.travel.domain.plan.TravelPlanRepository;
//import com.travel.domain.travel.dto.*;
//import com.travel.domain.travel.dto.city.TravelCityDto;
//import com.travel.domain.travel.dto.plan.TravelPlanSaveDto;
//import com.travel.domain.travel.service.TravelCityService;
//import com.travel.domain.travel.service.TravelPlanService;
//import com.travel.domain.travel.service.TravelService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class TravelTest {
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
//
//    @AfterEach
//    public void clean() {
//        travelRepository.deleteAll();
//        travelPlanRepository.deleteAll();
//        travelCityRepository.deleteAll();
//    }
//
//
//    @DisplayName("[여행] 여행등록_여행계획등록_도시등록_여행도시등록 일괄 테스트")
//    @Test
//    public void saveTravel_TravelPlan_City_TravelCity() {
//        //여행등록
//        Long travelId = travelService.save(TravelSaveDto.builder()
//                .name("강원여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20230113")
//                .travelEndDate("20230117")
//                .build());
//
//        //여행계획 등록
//        travelPlanService.save(TravelPlanSaveDto.builder()
//                .travelId(travelId)
//                .travelDate("20230113")
//                .place("경포대")
//                .build());
//
//        //도시등록
//        Long cityId = cityService.save(JavaCitySaveDto.builder()
//                .name("과천")
//                .category(CityCategory.GYEONGGI)
//                .build());
//
//        //여행도시 등록
//        travelCityService.save(TravelCityDto.builder()
//                .travelId(travelId)
//                .cityId(cityId)
//                .build());
//
//        List<Travel> travelList = travelRepository.findAll();
//        assertThat(travelList.get(0).getName()).isEqualTo("강원여행 렛츠 고");
//    }
//
//    @DisplayName("[여행] 여행, 여행계획 등록 후 여행계획 편집까지 수행")
//    @Test
//    public void updateTravelPlan() {
//        //여행등록
//        Long travelId = travelService.save(TravelSaveDto.builder()
//                .name("서울여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20230108")
//                .travelEndDate("20230115")
//                .build());
//
//        //여행계획 등록
//        travelPlanService.save(TravelPlanSaveDto.builder()
//                .travelId(travelId)
//                .travelDate("20230108")
//                .place("신림")
//                .build());
//
//        //여행계획 편집
//        List<TravelPlanSaveDto> planSaveDtoList = new ArrayList<>();
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20230108").place("신촌").orderNo(1).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20230108").place("선릉").orderNo(2).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20230108").place("강남").orderNo(3).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20230108").place("홍대").orderNo(4).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20230108").place("동대문").orderNo(5).build());
//
//        travelPlanService.saveAll(planSaveDtoList);
//
//        //결과확인
//        List<TravelPlan> list = travelPlanRepository.findAll();
//        assertThat(list.get(0).getPlace()).isEqualTo("신촌");
//    }
//
//    @DisplayName("[여행] 등록한 여행에 대한 여행계획 등록 후 일정 변경")
//    @Test
//    public void updateTravel_TravelPlan_TravelCity() throws Exception {
//        //여행등록
//        Long travelId = travelService.save(TravelSaveDto.builder()
//                .name("대구여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20221229")
//                .travelEndDate("20230101")
//                .build());
//
//        //여행계획 등록
//        List<TravelPlanSaveDto> planSaveDtoList = new ArrayList<>();
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("대학로2").orderNo(1).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("대학로").orderNo(2).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("계명대").orderNo(3).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("서문시장").orderNo(4).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("경북대").orderNo(5).build());
//
//        travelPlanService.saveAll(planSaveDtoList);
//
//        /**
//         * Travel 일정 변경 (Plan에 등록된 일정까지 변경)
//         * 여행 시작일이 기존일보다 늦춰지면 변경되는 시작일 이전에 등록된 여행계획을 변경된 시작일로 변경
//         * 여행 종료일이 기존일보다 앞당겨진다면 변경되는 종료일 이후에 등록된 여행계획을 변경된 종료일로 변경
//         */
//        travelService.update(travelId, TravelUpdateDto.builder()
//                .name("전주여행 렛츠 고")
//                .travelStartDate("20221230")
//                .travelEndDate("20230101")
//                .build());
//
//        //결과확인
//        List<TravelPlan> list = travelPlanRepository.findByTravelIdAndTravelDate(travelId, "20221230");
//        assertThat(list.get(0).getPlace()).isEqualTo("대학로2");
//    }
//
//    @DisplayName("[여행] 등록한 여행에 도시정보를 추가")
//    @Test
//    public void createTravel_createTravelCity_updateTravelCity() throws Exception {
//        //도시등록
//        Long cityId = cityService.save(JavaCitySaveDto.builder()
//                .name("대구")
//                .category(CityCategory.GYEONGSANG)
//                .build());
//
//        //여행등록
//        Long travelId = travelService.save(TravelSaveDto.builder()
//                .name("대구여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20221229")
//                .travelEndDate("20230101")
//                .build());
//
//        //여행도시등록
//        Long travelCityId = travelCityService.save(TravelCityDto.builder()
//                .cityId(cityId)
//                .travelId(travelId)
//                .build());
//
//        travelCityService.update(travelCityId, cityId);
//
//        //결과확인
//        TravelCity travelCity = travelCityRepository.findById(travelCityId).get();
//        assertThat(travelCity.getCityId()).isEqualTo(cityId);
//    }
//
//    @DisplayName("[여행] 여행, 여행계획, 여행도시 등록 후 삭제")
//    @Test
//    public void createTravel_delete() throws Exception {
//        //여행등록
//        Long travelId = travelService.save(TravelSaveDto.builder()
//                .name("대구여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20221229")
//                .travelEndDate("20230101")
//                .build());
//
//        //여행계획 등록
//        travelPlanService.save(TravelPlanSaveDto.builder()
//                .travelId(travelId)
//                .travelDate("20221229")
//                .place("이월드")
//                .build());
//
//        //도시등록
//        Long cityId = cityService.save(JavaCitySaveDto.builder()
//                .name("대구")
//                .category(CityCategory.GYEONGSANG)
//                .build());
//
//        //여행도시 등록
//        travelCityService.save(TravelCityDto.builder()
//                .travelId(travelId)
//                .cityId(cityId)
//                .build());
//
//        travelService.delete(travelId);
//
//        List<Travel> travelList = travelRepository.findAll();
//        assertThat(travelList.size()).isEqualTo(0);
//
//        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
//        assertThat(travelPlanList.size()).isEqualTo(0);
//
//        List<TravelCity> travelCityList = travelCityRepository.findAll();
//        assertThat(travelCityList.size()).isEqualTo(0);
//    }
//
//    @DisplayName("[여행] 단일 여행 + 여행계획 조회")
//    @Test
//    public void get() {
//        //여행등록
//        Long travelId = travelService.save(TravelSaveDto.builder()
//                .name("대구여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20221229")
//                .travelEndDate("20230101")
//                .build());
//
//        //여행계획 편집
//        List<TravelPlanSaveDto> planSaveDtoList = new ArrayList<>();
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("대학로2").orderNo(1).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("대학로").orderNo(2).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("계명대").orderNo(3).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("서문시장").orderNo(4).build());
//        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(travelId).travelDate("20221229").place("경북대").orderNo(5).build());
//        travelPlanService.saveAll(planSaveDtoList);
//
//        //여행조회
//        TravelResponseDto travel = travelService.get(TravelRequestDto.builder().id(travelId).searchType(TravelSearchType.PLAN).build());
//        assertThat(travel.getName()).isEqualTo("대구여행 렛츠 고");
//        assertThat(travel.getTravelPlanList().get(0).getPlace()).isEqualTo("대학로2");
//    }
//
//}
