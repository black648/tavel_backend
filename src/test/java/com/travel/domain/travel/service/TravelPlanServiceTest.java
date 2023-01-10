package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.plan.TravelPlan;
import com.travel.domain.travel.domain.plan.TravelPlanRepository;
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TravelPlanServiceTest {
    @Autowired
    TravelService travelService;

    @Autowired
    TravelPlanService travelPlanService;

    @Autowired
    TravelPlanRepository travelPlanRepository;

    @DisplayName("[단위테스트] 여행계획 등록")
    @Test
    public void save() {
        //given
        travelPlanService.save(TravelPlanSaveDto.builder()
                .travelId(1)
                .travelDate("20221229")
                .place("동성로")
                .build());

        //when
        List<TravelPlan> list = travelPlanRepository.findAll();

        //then
        assertThat(list.get(0).getPlace()).isEqualTo("동성로");
    }

    @DisplayName("[단위테스트] 여행계획 일괄 등록(Update 기능)")
    @Test
    public void saveAll() {
        List<TravelPlanSaveDto> planSaveDtoList = new ArrayList<>();
        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(1).travelDate("20230101").place("대학로2").orderNo(1).build());
        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(1).travelDate("20230101").place("대학로").orderNo(2).build());
        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(1).travelDate("20230101").place("계명대").orderNo(3).build());
        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(1).travelDate("20230101").place("서문시장").orderNo(4).build());
        planSaveDtoList.add(TravelPlanSaveDto.builder().travelId(1).travelDate("20230101").place("경북대").orderNo(5).build());
        //given
        travelPlanService.saveAll(planSaveDtoList);

        //when
        List<TravelPlan> list = travelPlanRepository.findAll();

        //then
        assertThat(list.get(0).getPlace()).isEqualTo("대학로2");
    }
}
