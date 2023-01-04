package com.travel.domain.city.service;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityCategory;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.request.CitySaveRequestDto;
import com.travel.domain.city.dto.request.CityUpdateRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
        cityService.save(CitySaveRequestDto.builder()
                .name("서울")
                .category(CityCategory.SEOUL)
                .build());

        //when
        List<City> list = cityRepository.findAll();

        //then
        assertThat(list.get(0).getName()).isEqualTo("서울");
        assertThat(list.get(0).getCategory()).isEqualTo(CityCategory.SEOUL);
    }

    @DisplayName("[단위테스트] 도시명 수정")
    @Test
    public void update() {
        //given
        Long saveCity = cityService.save(CitySaveRequestDto.builder()
                .name("서울")
                .category(CityCategory.SEOUL)
                .build());

        //when
        cityService.update(CityUpdateRequestDto.builder()
                .id(saveCity)
                .name("성남")
                .category(CityCategory.GYEONGGI)
                .build());

        //then
        List<City> cityList = cityRepository.findAll();
        assertThat(cityList.get(0).getName()).isEqualTo("성남");
        assertThat(cityList.get(0).getCategory()).isEqualTo(CityCategory.GYEONGGI);
    }

}