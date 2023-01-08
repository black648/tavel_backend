package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.Travel;
import com.travel.domain.travel.domain.TravelRepository;
import com.travel.domain.travel.dto.TravelSaveDto;
import com.travel.domain.travel.dto.TravelUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TravelServiceTest {

    @Autowired
    TravelService travelService;

    @Autowired
    TravelRepository travelRepository;

//    @AfterEach
//    public void clean() {
//        travelRepository.deleteAll();
//    }

    @DisplayName("[단위테스트] 여행 등록")
    @Test
    public void save() {
        //given
        travelService.save(TravelSaveDto.builder()
                .name("대구여행 렛츠 고")
                .userId("gogogo")
                .travelStartDate("20221229")
                .travelEndDate("20230101")
                .build());

        //when
        List<Travel> list = travelRepository.findAll();

        //then
        assertThat(list.get(0).getName()).isEqualTo("대구여행 렛츠 고");
    }

    @DisplayName("[단위테스트] 여행 수정")
    @Test
    public void update() throws Exception {
        //given
//        Long saveCity = travelService.save(TravelSaveDto.builder()
//                .name("대구여행 렛츠 고")
//                .userId("gogogo")
//                .travelStartDate("20221229")
//                .travelEndDate("20230101")
//                .build());

        //when
        travelService.update(1L, TravelUpdateDto.builder()
                .name("전주여행 렛츠 고")
                .travelStartDate("20221230")
                .travelEndDate("20230101")
                .build());

        //then
//        checkSelectCityData("전주여행 렛츠 고", "20221230", "20230102");
    }

    @DisplayName("[단위테스트] 여행 삭제 ")
    @Test
    public void delete() {
        //given
        Long saveCity = travelService.save(TravelSaveDto.builder()
                .name("대구여행 렛츠 고")
                .userId("gogogo")
                .travelStartDate("20221229")
                .travelEndDate("20230101")
                .build());

        //when
        travelService.delete(saveCity);

        //then
        List<Travel> travelList = travelRepository.findAll();
        assertThat(travelList.size()).isEqualTo(0);
    }


}
