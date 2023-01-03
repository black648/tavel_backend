package com.travel.domain.city.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.domain.city.domain.CityCategory;
import com.travel.domain.city.dto.request.CitySaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mvc;



    @DisplayName("도시를 등록한다.")
    @Test
    public void save() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CitySaveRequestDto requestDto = CitySaveRequestDto.builder()
                                                .name("서울")
                                                .category(CityCategory.SEOUL)
                                                .build();

        mvc.perform(post("/city/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
