package com.travel.domain.travel.service

import com.travel.domain.travel.domain.city.TravelCityRepository
import com.travel.domain.travel.dto.city.TravelCityDto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TravelCityServiceTest @Autowired constructor(
    private var travelCityService: TravelCityService,
    private var travelCityRepository: TravelCityRepository
) {

    @AfterEach
    fun clean() {
        travelCityRepository.deleteAll()
    }

    @DisplayName("[단위테스트] 도시명 등록")
    @Test
    fun save() {
        //given
        travelCityService.save(TravelCityDto(travelId = 2L, cityId = 8L))

        //when
        val list = travelCityRepository.findAll()

        //then
        Assertions.assertThat(list[0].cityId).isEqualTo(2)
    }

    @DisplayName("[단위테스트] 도시 수정")
    @Test
    fun update() {
        //given
        travelCityService.update(2L, 5L)

        //when
        val list = travelCityRepository.findAll()

        //then
        Assertions.assertThat(list[0].cityId).isEqualTo(5)
    }

    @DisplayName("[단위테스트] 도시 삭제 ")
    @Test
    fun delete() {
        //given
        travelCityService.save(TravelCityDto(travelId = 1L, cityId = 8L))

        //when
        travelCityService.delete(1L)

        //then
        val travelCityList = travelCityRepository.findAll()
        Assertions.assertThat(travelCityList.size).isEqualTo(0)
    }
}