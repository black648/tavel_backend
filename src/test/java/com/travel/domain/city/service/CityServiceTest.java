package com.travel.domain.city.service;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityCategory;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.request.CitySaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CityServiceTest {
    @Autowired
    CityService cityService;

    @Autowired
    CityRepository cityRepository;

    @DisplayName("[단위테스트] 도시명 등록")
    @Test
    public void save() {
        //given
        CitySaveRequestDto requestDto = CitySaveRequestDto.builder()
                .name("서울")
                .category(CityCategory.SEOUL)
                .build();

        //when
        cityService.save(requestDto);

        //then
        List<City> list = cityRepository.findAll();
        assertThat(list.get(0).getName()).isEqualTo("서울");
        assertThat(list.get(0).getCategory()).isEqualTo(CityCategory.SEOUL);
    }
}