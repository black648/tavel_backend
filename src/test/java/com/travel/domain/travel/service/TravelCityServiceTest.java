package com.travel.domain.travel.service;

import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.city.TravelCityRepository;
import com.travel.domain.travel.dto.city.TravelCityDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TravelCityServiceTest {
    @Autowired
    TravelCityService travelCityService;

    @Autowired
    TravelCityRepository travelCityRepository;

    @DisplayName("[단위테스트] 도시명 등록")
    @Test
    public void save() {
        //given
        travelCityService.save(TravelCityDto.builder()
                .travelId(1L)
                .cityId(2L)
                .build());

        //when
        List<TravelCity> list = travelCityRepository.findAll();
        //then
        assertThat(list.get(0).getCityId()).isEqualTo(2);
    }
}
