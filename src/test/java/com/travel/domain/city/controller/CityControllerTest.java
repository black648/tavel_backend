package com.travel.domain.city.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityCategory;
import com.travel.domain.city.domain.CityRepository;
import com.travel.domain.city.dto.CityDto;
import com.travel.domain.city.dto.CitySaveDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CityControllerTest {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private MockMvc mvc;

    @AfterEach
    public void clean() {
        cityRepository.deleteAll();
    }

    @DisplayName("[API테스트] 도시 등록")
    @Test
    public void save() throws Exception {
        mvc.perform(post("/city/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(
                                CitySaveDto.builder()
                                    .name("서울")
                                    .category(CityCategory.SEOUL)
                                    .build())))
                .andExpect(status().isOk());

        //then
        checkSelectCityData("서울", CityCategory.SEOUL);
    }

    @DisplayName("[API테스트] 도시 수정")
    @Test
    public void update() throws Exception {
        //given
        City saveCity = cityRepository.save(City.builder()
                .name("원주")
                .category(CityCategory.GANGWON)
                .build());

        //when
        mvc.perform(put("/city/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(
                                CityDto.builder()
                                        .id(saveCity.getId())
                                        .name("광주")
                                        .category(CityCategory.GYEONGGI)
                                        .build())))
                .andExpect(status().isOk());

        //then
        checkSelectCityData("광주", CityCategory.GYEONGGI);
    }

    @DisplayName("[API테스트] 도시 수정")
    @Test
    public void get() throws Exception {
        //given
        City saveCity = cityRepository.save(City.builder()
                .name("원주")
                .category(CityCategory.GANGWON)
                .build());

        //when
        mvc.perform(post("/city/get/{id}", saveCity.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(
                                saveCity.getId())))
                .andExpect(status().isOk());

        //then
        checkSelectCityData("원주", CityCategory.GANGWON);
    }

    private void checkSelectCityData(String name, CityCategory category) {
        List<City> cityList = cityRepository.findAll();
        assertThat(cityList.get(0).getName()).isEqualTo(name);
        assertThat(cityList.get(0).getCategory()).isEqualTo(category);
    }
}
