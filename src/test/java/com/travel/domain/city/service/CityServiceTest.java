package com.travel.domain.city.service;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityCategory;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.CitySaveRequestDto;
import com.travel.domain.city.dto.CityDto;
import com.travel.domain.travel.dto.city.TravelCityDto;
import com.travel.domain.travel.service.TravelCityService;
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
    TravelCityService travelCityService;

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

        //when & then
        checkSelectCityData("서울", CityCategory.SEOUL);
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
        cityService.update(CityDto.builder()
                .id(saveCity)
                .name("성남")
                .category(CityCategory.GYEONGGI)
                .build());

        //then
        checkSelectCityData("성남", CityCategory.GYEONGGI);
    }

    @DisplayName("[단위테스트] 도시 삭제 ")
    @Test
    public void delete() {
        //given
        Long saveCity = cityService.save(CitySaveRequestDto.builder()
                .name("서울")
                .category(CityCategory.SEOUL)
                .build());
        travelCityService.save(TravelCityDto.builder()
                .travelId(1L)
                .cityId(saveCity)
                .build());

        //when
        cityService.delete(saveCity);

        //then
        List<City> cityList = cityRepository.findAll();
        assertThat(cityList.size()).isEqualTo(1);
    }

    private void checkSelectCityData(String name, CityCategory category) {
        List<City> cityList = cityRepository.findAll();
        assertThat(cityList.get(0).getName()).isEqualTo(name);
        assertThat(cityList.get(0).getCategory()).isEqualTo(category);
    }

}